import { useState,useContext,useEffect } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import './Style/VideoList.css';
import { useNavigate } from "react-router-dom";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { Video } from "./models/video";
import videoService from "../services/video.service";
import { videomin } from "./models/video";
import { UserContext } from '../App';
import { toast } from 'react-toastify';


function VideoList() {


const navigate=useNavigate();
const[videos,setVideos]=useState([])
const[isLoading, setisLoading] = useState(true);
const {isLoggedIn,isAdmin} = useContext(UserContext);

useEffect(() => {
  if (isLoading) {
      videoService.getVideo().then((response) => {
      console.log(response.length)
      for (let i=0; i<response.length; i++) {
        if((videos.length<response.length)){
        let id=response[i].link.split("?")[0].split("/")
        let video = new videomin(response[i].id, "https://img.youtube.com/vi/"+id[id.length-1]+"/0.jpg", response[i].link, response[i].uploader.fullName, response[i].name, response[i].uploadLocalDate)
        videos.push(video) }
      }
      console.log(videos)
     setisLoading(false) } )
    }

  },[]);

  if (isLoading) {
    return <div className="App">Loading...</div>;
  } else {
    return (

      <div>
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"/>
      
          <h1>
              Videos
          </h1>
      
          <div className='add-movie-button' onClick={()=>{
      if(isLoggedIn){
        navigate("/upload")
      }
      else{
        toast.error("You need to login to upload a video")
      }}}>
            <a>
              <FontAwesomeIcon icon={faPlus} style={{color: "#ffffff",}} />
            </a>

          </div>
          
                {videos.map((video)=>(
      
                <div className="video-container" onClick={()=>navigate("/video",{state:video})}>
      
                <div>
                  <img className='moviePhoto' src={video.imageurl}></img>
                </div>
          
      
                 <div>
                    <div className="videoname">
                    {
                      video.videoname
                    }
                    </div>
                    <div className="uploader"> 
                      Upload Date: {video.date}
                    </div>
                    
                    <div className='uploader'>
                     {video.uploader}
                    </div>
                </div>
              </div>
             ))}
      </div>
      )
  }


   
}

export default VideoList;
