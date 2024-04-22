import api from "./api";
import axios from 'axios';

class ReviewService{

    addreview(reviewer,video,rating){
        return api
        .post("/review/",{
            reviewer,
            video,
            rating
        })
        .then(response => {
            return response.data;
        })
        .catch(error => {
            throw error; // Rethrow the error to handle it in the caller
        });
    }

} export default new ReviewService();