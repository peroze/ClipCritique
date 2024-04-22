import api from "./api";

class VideoService {
    
    deleteVideo(video_id){
        return api
        .delete("/video/"+video_id)
        .then(response => {
          return response.data;
        })
        .catch(error => {
            console.error("Error deleting video:", error);
            throw error; // Rethrow the error to handle it in the caller
        });
    }

    

}

export default new VideoService() ;