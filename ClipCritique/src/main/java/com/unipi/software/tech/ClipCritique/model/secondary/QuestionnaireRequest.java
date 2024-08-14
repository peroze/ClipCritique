package com.unipi.software.tech.ClipCritique.model.secondary;

import com.unipi.software.tech.ClipCritique.model.VideoCategory;


public class QuestionnaireRequest {
    private Long id;
    private VideoCategory category1;
    private VideoCategory category2;
    private VideoCategory category3;

    private Long prefer_songs1;
    private Long prefer_songs2;
    private Long prefer_songs3;
    private Long user;

    public QuestionnaireRequest(VideoCategory category1, VideoCategory category2, VideoCategory category3, Long prefer_songs1, Long prefer_songs2, Long prefer_songs3, Long user) {
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.prefer_songs1 = prefer_songs1;
        this.prefer_songs2 = prefer_songs2;
        this.prefer_songs3 = prefer_songs3;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VideoCategory getCategory2() {
        return category2;
    }

    public void setCategory2(VideoCategory category2) {
        this.category2 = category2;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getPrefer_songs3() {
        return prefer_songs3;
    }

    public void setPrefer_songs3(Long prefer_songs3) {
        this.prefer_songs3 = prefer_songs3;
    }

    public Long getPrefer_songs2() {
        return prefer_songs2;
    }

    public void setPrefer_songs2(Long prefer_songs2) {
        this.prefer_songs2 = prefer_songs2;
    }

    public Long getPrefer_songs1() {
        return prefer_songs1;
    }

    public void setPrefer_songs1(Long prefer_songs1) {
        this.prefer_songs1 = prefer_songs1;
    }

    public VideoCategory getCategory3() {
        return category3;
    }

    public void setCategory3(VideoCategory category3) {
        this.category3 = category3;
    }

    public VideoCategory getCategory1() {
        return category1;
    }

    public void setCategory1(VideoCategory category1) {
        this.category1 = category1;
    }
}
