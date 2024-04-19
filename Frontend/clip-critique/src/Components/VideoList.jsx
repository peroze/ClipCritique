import { useState,useContext } from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import './Style/VideoList.css';
import { useNavigate } from "react-router-dom";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { UserContext } from '../App';
import { toast } from 'react-toastify';


function VideoList() {

const[imageurl, setimageurl] = useState("https://img.youtube.com/vi/YlTwnqgDfnc/0.jpg");
const[uploader, setuploader] = useState("Konstantinos");
const[rating, setrating] = useState(4.75);
const count = Math.floor(rating);
const percentage = (rating-count)*100;
const[videoname, setvideoname] = useState("KOULHS KOULHS KOULHS");
const navigate=useNavigate();

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
    <div className="video-container">

        <div>
            <img className='moviePhoto' src={imageurl}></img>

            
        </div>
            
        
            <div>
                <div className="videoname">
                    {
                        videoname
                    }
                </div>

            <div className='rating'>
            {(() => {
              const arr=[];
                for (let i=0; i<count; i++) {
                  arr.push(<div id='ic'>
                  <i className='fas fa-music' icon={faMusic} />
  
                    
                </div>)
                } if (percentage>25 && percentage<75 ) {
                  
                  arr.push(<div id='ic'>
                  <i id='half' className='fas fa-music' icon={faMusic} />
                    
                </div>) 
                }
  
                if(percentage > 74 ) {
                  arr.push(<div id='ic'>
                  <i className='fas fa-music' icon={faMusic} />
  
                </div>)
                }
                  return arr;
            })()} 
          
  
  
          </div>

          <div className='uploader'>

            {uploader}
  
          </div>


        </div>


    </div>

</div>
)
   
}

export default VideoList;