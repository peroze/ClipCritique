import { useState,useContext } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import './Style/VideoList.css';
import { useNavigate } from "react-router-dom";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { Video } from "./models/video";
import { UserContext } from '../App';
import { toast } from 'react-toastify';


function VideoList() {


const navigate=useNavigate();
const[videos,setVideos]=useState([new Video(1,"https://img.youtube.com/vi/YlTwnqgDfnc/0.jpg","https://www.youtube.com/embed/YlTwnqgDfnc?si=F0wKg2zQq2Jj-pso","Konstantinos","KOULHS KOULHS KOULHS",4.75,"15/07/2024",Math.floor(4.75),(4.75-Math.floor(4.75))*100),new Video(1,"https://img.youtube.com/vi/YlTwnqgDfnc/0.jpg","https://www.youtube.com/embed/YlTwnqgDfnc?si=F0wKg2zQq2Jj-pso","Konstantinos","KOULHS KOULHS KOULHS",4.75,"15/07/2024",Math.floor(4.75),(4.75-Math.floor(4.75))*100)])

const {isLoggedIn} = useContext(UserContext);

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

              <div className='rating'>
              {(() => {
                    const arr=[];
                    for (let i=0; i<video.count; i++) {
                        arr.push(<div id='ic'>
                        <i className='fas fa-music' icon={faMusic} />
                       </div>)
                    } if (video.percentage>25 && video.percentage<75 ) {
                        arr.push(<div id='ic'>
                                    <i id='half' className='fas fa-music' icon={faMusic} />
                                  </div>) 
                    }
                    if(video.percentage > 74 ) {
                      arr.push(<div id='ic'>
                                  <i className='fas fa-music' icon={faMusic} />

                              </div>)
                    }
                  return arr;
              })()} 
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

export default VideoList;