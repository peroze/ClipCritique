package com.unipi.software.tech.ClipCritique.service;

import com.unipi.software.tech.ClipCritique.model.*;
import com.unipi.software.tech.ClipCritique.repository.WatchHistoryRepository;
import com.unipi.software.tech.ClipCritique.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final WatchHistoryRepository watchHistoryRepository;
    private final WatchHistoryService watchhistoryservice;
    private final QuestionnaireService questionnaireservice;
    private final UserService userservice;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public Video addNewVideo(Video video) {
        Optional<Video> videoOptional = videoRepository.findByLink(video.getLink());
        if (videoOptional.isPresent()) {
            throw new IllegalStateException("Video link already in the list");
        }
        Video createdVideo = new Video(video.getLink(), video.getUploader(), video.getName(), video.getCategory(), video.getAgerating(), video.getArtist());
        return videoRepository.save(createdVideo);
    }

    public List<Video> Questionnaire() {
        return videoRepository.findquestionnaire();
    }

    public void deleteVideoById(Long id) {
        boolean exists = videoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Video with id " + id + " does not exist");
        }
        videoRepository.deleteById(id);
    }


    public double getAverageRating(Long id) {
        Integer minus = 0;
        List<WatchHistory> watchHistories = watchHistoryRepository.findReviewsByVideoId(id);
        if (watchHistories == null || watchHistories.isEmpty()) {
            return 0.0;
        }
        int totalRating = 0;
        for (WatchHistory watchHistory : watchHistories) {
            if (watchHistory.getRating() == -1) {
                minus = minus + 1;
                continue;
            }
            totalRating += watchHistory.getRating();
        }
        if (watchHistories.size() - minus == 0) {
            return 0.0;
        }
        return (double) totalRating / (watchHistories.size() - minus);
    }

    List<Video> findByTheCategory(VideoCategory category) {
        List<Video> temp = videoRepository.findByTheCategory(category);
        return temp;
    }

    public List<Video> getPersonalisation(Long user_id) {
        User user = userservice.getUserById(user_id).orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));
        List<WatchHistory> watchvideo = watchhistoryservice.findReviewsByUserId(user_id);
        List<Video> videos = new ArrayList<>();
        for (WatchHistory watch : watchvideo) {
            videos.add(watch.getVideo());
        }

        HashMap<VideoCategory, Integer> frequentcategory = countfrequency(videos);
        List<WatchHistory> highratingvideo = watchhistoryservice.findReviewsByUserIdAndRating(user_id);
        List<Video> videosrated = new ArrayList<>();

        for (WatchHistory watch : highratingvideo) {
            videosrated.add(watch.getVideo());
        }

        HashMap<VideoCategory, Integer> ratedcategoryfrequency = countfrequency(videosrated);
        List<Questionnaire> qs = questionnaireservice.getQuestionnaireByUserId(user_id);
        List<VideoCategory> qs_categories = new ArrayList<>();
        qs_categories.add(qs.get(0).getCategory1());
        qs_categories.add(qs.get(0).getCategory2());
        qs_categories.add(qs.get(0).getCategory3());

        List<Video> qs_videos = new ArrayList<>();
        Video videotemp = getVideoById(qs.get(0).getPrefer_songs1()).orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));
        qs_videos.add(videotemp);
        videotemp = getVideoById(qs.get(0).getPrefer_songs2()).orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));
        qs_videos.add(videotemp);
        videotemp = getVideoById(qs.get(0).getPrefer_songs3()).orElseThrow(() -> new IllegalArgumentException("Video couldn't be found"));
        qs_videos.add(videotemp);

        List<User> agegeneration = userservice.findUserByAge(user.getDateOfBirth());
        List<Video> agevideos = new ArrayList<>();
        for (User age : agegeneration) {
            List<WatchHistory> wh = watchhistoryservice.findReviewsByUserId(age.getId());
            for (WatchHistory w : wh) {
                agevideos.add(w.getVideo());
            }
        }
        HashMap<VideoCategory, Integer> categoriesfrequency = countfrequency(agevideos);
        List<Video> videostosuggest = new ArrayList<>();
        Random rand = new Random();
        if (videos.size() > 10) {
            List<Video> suggestedagevideosbywatchhistory = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(frequentcategory).getKey()); //50
            for (int i = 0; i < suggestedagevideosbywatchhistory.size(); i++) {
                for (int j = i + 1; j < videos.size(); j++) {
                    if (suggestedagevideosbywatchhistory.get(i).getId() == videos.get(j).getId()) {
                        suggestedagevideosbywatchhistory.remove(suggestedagevideosbywatchhistory.get(i));
                    }
                }
            }
            List<Video> suggestedagevideosbyrating = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(ratedcategoryfrequency).getKey()); //30
            for (int i = 0; i < suggestedagevideosbyrating.size(); i++) {
                for (int j = i + 1; j < videos.size(); j++) {
                    if (suggestedagevideosbyrating.get(i).getId() == videos.get(j).getId()) {
                        suggestedagevideosbyrating.remove(suggestedagevideosbyrating.get(i));
                    }
                }
            }

            frequentcategory.remove(getMaxEntryInMapBasedOnValue(frequentcategory).getKey());
            frequentcategory.remove(getMaxEntryInMapBasedOnValue(ratedcategoryfrequency).getKey());
            List<Video> suggestedagevideosbywatchhistory1 = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(frequentcategory).getKey()); //50
            for (int i = 0; i < suggestedagevideosbywatchhistory1.size(); i++) {
                for (int j = i + 1; j < videos.size(); j++) {
                    if (suggestedagevideosbywatchhistory1.get(i).getId() == videos.get(j).getId()) {
                        suggestedagevideosbywatchhistory1.remove(suggestedagevideosbywatchhistory1.get(i));
                        break;
                    }
                }
            }
            List<Video> suggestedagevideosbyrating1 = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(ratedcategoryfrequency).getKey()); //30
            for (int i = 0; i < suggestedagevideosbyrating1.size(); i++) {
                for (int j = i + 1; j < videos.size(); j++) {
                    if (suggestedagevideosbyrating1.get(i).getId() == videos.get(j).getId()) {
                        suggestedagevideosbyrating1.remove(suggestedagevideosbyrating1.get(i));
                        break;
                    }
                }
            }
            if (suggestedagevideosbyrating.size() >= 5) {
                for (Integer i = 0; i < 5; i++) {
                    videostosuggest.add(suggestedagevideosbyrating.get(rand.nextInt(0, suggestedagevideosbyrating.size())));
                }
            } else {
                for (Integer i = 0; i < suggestedagevideosbyrating.size(); i++) {
                    videostosuggest.add(suggestedagevideosbyrating.get(rand.nextInt(0, suggestedagevideosbyrating.size())));
                }
            }
            if (suggestedagevideosbywatchhistory.size() >=3) {
                for (Integer i = 0; i < 3; i++) {
                    videostosuggest.add(suggestedagevideosbywatchhistory.get(rand.nextInt(0, suggestedagevideosbywatchhistory.size())));
                }
            } else {
                for (Integer i = 0; i < suggestedagevideosbywatchhistory.size(); i++) {
                    videostosuggest.add(suggestedagevideosbywatchhistory.get(rand.nextInt(0, suggestedagevideosbywatchhistory.size())));
                }
            }
            if (suggestedagevideosbyrating1.size() >= 5) {
                for (Integer i = 0; i < 5; i++) {
                    videostosuggest.add(suggestedagevideosbyrating1.get(rand.nextInt(0, suggestedagevideosbyrating1.size())));
                }
            } else {
                for (Integer i = 0; i < suggestedagevideosbyrating.size(); i++) {
                    videostosuggest.add(suggestedagevideosbyrating1.get(rand.nextInt(0, suggestedagevideosbyrating1.size())));
                }
            }
            if (suggestedagevideosbywatchhistory.size() >=3) {
                for (Integer i = 0; i < 3; i++) {
                    videostosuggest.add(suggestedagevideosbywatchhistory1.get(rand.nextInt(0, suggestedagevideosbywatchhistory1.size())));
                }
            } else {
                for (Integer i = 0; i < suggestedagevideosbywatchhistory.size(); i++) {
                    videostosuggest.add(suggestedagevideosbywatchhistory1.get(rand.nextInt(0, suggestedagevideosbywatchhistory1.size())));
                }
            }

            List<Video> category1videos = videoRepository.findByTheCategory(qs_categories.get(0));
            List<Video> category2videos = videoRepository.findByTheCategory(qs_categories.get(1));
            List<Video> suggestedagevideos = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(categoriesfrequency).getKey()); //2
            if (agegeneration.size() != 0) {
                if (suggestedagevideos.size() > 2) {
                    for (Integer i = 0; i < 2; i++) {
                        videostosuggest.add(suggestedagevideos.get(rand.nextInt(0, suggestedagevideos.size())));
                    }
                } else {
                    for (Integer i = 0; i < suggestedagevideos.size(); i++) {
                        videostosuggest.add(suggestedagevideos.get(i));
                    }
                }
            }
            if (category1videos.size() > 1) {
                for (Integer i = 0; i < 1; i++) {
                    videostosuggest.add(category1videos.get(rand.nextInt(0, category1videos.size())));
                }
            }
            if (category2videos.size() > 1) {
                for (Integer i = 0; i < 1; i++) {
                    videostosuggest.add(category2videos.get(rand.nextInt(0, category2videos.size())));
                }
            }

        } else {
            if (videos.size() == 0) {

                List<Video> category1videos = videoRepository.findByTheCategory(qs_categories.get(0)); //10
                List<Video> category2videos = videoRepository.findByTheCategory(qs_categories.get(1)); //5
                List<Video> category3videos = videoRepository.findByTheCategory(qs_categories.get(2)); //3
                if (agegeneration.size() != 0) {
                    List<Video> suggestedagevideos = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(categoriesfrequency).getKey()); //2
                    if (suggestedagevideos.size() > 2) {
                        for (Integer i = 0; i < 2; i++) {
                            videostosuggest.add(suggestedagevideos.get(rand.nextInt(0, suggestedagevideos.size())));
                        }
                    } else {
                        for (Integer i = 0; i < suggestedagevideos.size(); i++) {
                            videostosuggest.add(suggestedagevideos.get(i));
                        }
                    }
                }
                System.out.println(category1videos.get(0).getName());
                if (category1videos.size() > 10) {
                    for (Integer i = 0; i < 10; i++) {
                        videostosuggest.add(category1videos.get(rand.nextInt(0, category1videos.size())));
                    }
                } else {
                    for (Integer i = 0; i < category1videos.size(); i++) {
                        videostosuggest.add(category1videos.get(i));
                    }
                }

                if (category2videos.size() > 5) {
                    for (Integer i = 0; i < 5; i++) {
                        videostosuggest.add(category2videos.get(rand.nextInt(0, category2videos.size())));
                    }
                } else {
                    for (Integer i = 0; i < category2videos.size(); i++) {
                        videostosuggest.add(category2videos.get(i));
                    }
                }

                if (category3videos.size() > 3) {
                    for (Integer i = 0; i < 3; i++) {
                        videostosuggest.add(category3videos.get(rand.nextInt(0, category3videos.size())));
                    }
                } else {
                    for (Integer i = 0; i < category3videos.size(); i++) {
                        videostosuggest.add(category3videos.get(i));
                    }
                }

            } else {
                List<Video> suggestedagevideosbywatchhistory = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(frequentcategory).getKey()); //50
                for (int i = 0; i < suggestedagevideosbywatchhistory.size(); i++) {
                    for (int j = i + 1; j < videos.size(); j++) {
                        if (suggestedagevideosbywatchhistory.get(i).getId() == videos.get(j).getId()) {
                            suggestedagevideosbywatchhistory.remove(suggestedagevideosbywatchhistory.get(i));
                            break;}
                    }
                }

                List<Video> suggestedagevideosbyrating = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(ratedcategoryfrequency).getKey()); //30
                for (int i = 0; i < suggestedagevideosbyrating.size(); i++) {
                    for (int j = i + 1; j < videos.size(); j++) {
                        if (suggestedagevideosbyrating.get(i).getId() == videos.get(j).getId()) {
                            suggestedagevideosbyrating.remove(suggestedagevideosbyrating.get(i));
                            break;
                        }
                    }
                }
                frequentcategory.remove(getMaxEntryInMapBasedOnValue(frequentcategory).getKey());
                frequentcategory.remove(getMaxEntryInMapBasedOnValue(ratedcategoryfrequency).getKey());
                if (suggestedagevideosbyrating.size() >= 4) {
                    for (Integer i = 0; i < 4; i++) {
                        videostosuggest.add(suggestedagevideosbyrating.get(rand.nextInt(0, suggestedagevideosbyrating.size())));
                    }
                } else {
                    for (Integer i = 0; i < suggestedagevideosbyrating.size(); i++) {
                        videostosuggest.add(suggestedagevideosbyrating.get(rand.nextInt(0, suggestedagevideosbyrating.size())));
                    }
                }
               if (suggestedagevideosbywatchhistory.size() >=4) {
                   for (Integer i = 0; i < 4; i++) {
                       videostosuggest.add(suggestedagevideosbywatchhistory.get(rand.nextInt(0, suggestedagevideosbywatchhistory.size())));
                   }
               } else {
                   for (Integer i = 0; i < suggestedagevideosbywatchhistory.size(); i++) {
                       videostosuggest.add(suggestedagevideosbywatchhistory.get(rand.nextInt(0, suggestedagevideosbywatchhistory.size())));
                   }
               }

                List<Video> category1videos = videoRepository.findByTheCategory(qs_categories.get(0));
                List<Video> category2videos = videoRepository.findByTheCategory(qs_categories.get(1));
                if (agegeneration.size() != 0) {

                    List<Video> suggestedagevideos = videoRepository.findByTheCategory(getMaxEntryInMapBasedOnValue(categoriesfrequency).getKey()); //2
                    if (suggestedagevideos.size() > 4) {
                        for (Integer i = 0; i < 4; i++) {
                            videostosuggest.add(suggestedagevideos.get(rand.nextInt(0, suggestedagevideos.size())));
                        }
                    } else {
                        for (Integer i = 0; i < suggestedagevideos.size(); i++) {
                            videostosuggest.add(suggestedagevideos.get(i));
                        }
                    }
                }

                if (category1videos.size() > 4) {
                    for (Integer i = 0; i < 4; i++) {
                        videostosuggest.add(category1videos.get(rand.nextInt(0, category1videos.size())));
                    }
                }
                if (category2videos.size() > 4) {
                    for (Integer i = 0; i < 4; i++) {
                        videostosuggest.add(category2videos.get(rand.nextInt(0, category2videos.size())));
                    }
                }
            }

        }
        if (videostosuggest.size() < 20) {
            List<Video> allvideos = videoRepository.findAll();
            for (int i = 0; i < allvideos.size(); i++) {
                for (int j = i + 1; j < videos.size(); j++) {
                    if (allvideos.get(i).getId() == videos.get(j).getId()) {
                        allvideos.remove(allvideos.get(i));
                    }
                }
            }
            for (Integer i = 0; i < 20 - videos.size(); i++) {
                videostosuggest.add(allvideos.get(rand.nextInt(0, allvideos.size())));
            }
        }
        return videostosuggest;
    }

    public static <K, V extends Comparable<V>>
    Map.Entry<K, V>
    getMaxEntryInMapBasedOnValue(Map<K, V> map) {

        // To store the result
        Map.Entry<K, V> entryWithMaxValue = null;

        // Iterate in the map to find the required entry
        for (Map.Entry<K, V> currentEntry :
                map.entrySet()) {

            if (
                    entryWithMaxValue == null

                            || currentEntry.getValue().compareTo(
                            entryWithMaxValue.getValue())
                            > 0) {

                entryWithMaxValue = currentEntry;
            }
        }

        // Return the entry with highest value
        return entryWithMaxValue;
    }

    public HashMap<VideoCategory, Integer> countfrequency(List<Video> videos) {
        HashMap<VideoCategory, Integer> categoriesfrequency = new HashMap<VideoCategory, Integer>();

        for (Video vd : videos) {
            if (categoriesfrequency.containsKey(vd.getCategory())) {
                categoriesfrequency.put(vd.getCategory(), categoriesfrequency.get(vd.getCategory()) + 1);
            } else {
                categoriesfrequency.put(vd.getCategory(), 1);
            }
        }
        return categoriesfrequency;
    }
}
