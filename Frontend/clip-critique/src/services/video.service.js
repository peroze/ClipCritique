import api from "./api";
import axios from 'axios';

class VideoService {
    getVideo(){
        return api
        .get("/video/")
        .then(response => {
          return response.data;
        });
    }

    addvideo(link,uploadDateTime,name,uploader){
      return api
      .post("/video/",{
          link,
          uploadDateTime,
          name,
          uploader
      })
      .then(response => {
          return response.data;
      })
      .catch(error => {
          throw error; // Rethrow the error to handle it in the caller
      });
  }

  getVideoReview(id){
        return api
        .get("/video/rating/"+id)
        .then(response => {
          return response.data;
        });
    }

} export default new VideoService




