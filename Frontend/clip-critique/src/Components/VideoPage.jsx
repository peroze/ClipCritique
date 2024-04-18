import './Style/VideoPage.css';
import { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';

    
function VideoPage(){
    const[rating, setrating] = useState(4.35);
    const[userrating, setuserrating] = useState(0);
    const count = Math.floor(rating);
    const percentage = (rating-count)*100;
    const[uploader, setuploader] = useState("Konstantinos");
    const[videourl, setvideourl] = useState("https://www.youtube.com/embed/YlTwnqgDfnc?si=F0wKg2zQq2Jj-pso");

  
    
      return (
      <div className="content-container">
  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"/>
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
          
            {rating}
  
  
          </div>
          <div className='video'>
            <iframe id='ytvideo' height='700' src={videourl} title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
          </div>
  
          <div className='uploader'>
            {uploader}
  
          </div>
  
          <div className='user-rating' >
  
            <h1> Your Rating:</h1> 
  
          <div className='icr' id='first' onClick={() => {
            document.getElementById('first').classList.remove('selected');
            document.getElementById('second').classList.remove('selected');
            document.getElementById('third').classList.remove('selected');
            document.getElementById('fourth').classList.remove('selected');
            document.getElementById('fifth').classList.remove('selected');
            setuserrating(1)
            document.getElementById('first').classList.add('selected');
          }}>
          
              <FontAwesomeIcon icon={faMusic} />
  
            </div>
            <div className='icr' id='second' onClick={() => {
                document.getElementById('first').classList.remove('selected');
                document.getElementById('second').classList.remove('selected');
                document.getElementById('third').classList.remove('selected');
                document.getElementById('fourth').classList.remove('selected');
                document.getElementById('fifth').classList.remove('selected');
                setuserrating(2)
                document.getElementById('first').classList.add('selected');
                document.getElementById('second').classList.add('selected');
  
                console.log(2)
              }}>
              
              <FontAwesomeIcon  icon={faMusic} />
  
            </div>
            <div className='icr' id='third' onClick={() => {
            document.getElementById('first').classList.remove('selected');
            document.getElementById('second').classList.remove('selected');
            document.getElementById('third').classList.remove('selected');
            document.getElementById('fourth').classList.remove('selected');
            document.getElementById('fifth').classList.remove('selected');
            setuserrating(3)
            document.getElementById('first').classList.add('selected');
            document.getElementById('second').classList.add('selected');
            document.getElementById('third').classList.add('selected');
          }}>
              <FontAwesomeIcon icon={faMusic} />
  
            </div>
            <div className='icr' id='fourth' onClick={() => {
            document.getElementById('first').classList.remove('selected');
            document.getElementById('second').classList.remove('selected');
            document.getElementById('third').classList.remove('selected');
            document.getElementById('fourth').classList.remove('selected');
            document.getElementById('fifth').classList.remove('selected');
            setuserrating(4)
            document.getElementById('first').classList.add('selected');
            document.getElementById('second').classList.add('selected');
            document.getElementById('third').classList.add('selected');
            document.getElementById('fourth').classList.add('selected');
  
          }}>
              <FontAwesomeIcon icon={faMusic} />
  
            </div>
            <div className='icr' id='fifth' onClick={() => {
            document.getElementById('first').classList.remove('selected');
            document.getElementById('second').classList.remove('selected');
            document.getElementById('third').classList.remove('selected');
            document.getElementById('fourth').classList.remove('selected');
            document.getElementById('fifth').classList.remove('selected');
            setuserrating(5)
            document.getElementById('first').classList.add('selected');
            document.getElementById('second').classList.add('selected');
            document.getElementById('third').classList.add('selected');
            document.getElementById('fourth').classList.add('selected');
            document.getElementById('fifth').classList.add('selected');
          }}>
              <FontAwesomeIcon icon={faMusic} />
  
            </div>
  
            <button class="button-56" role="button">Submit</button>
  
          </div>
  
        </div>
    );

}

export default VideoPage;