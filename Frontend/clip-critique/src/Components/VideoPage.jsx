import './Style/VideoPage.css';
import { useState,useContext } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import { useLocation } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import { UserContext } from '../App';
import ReportVideoModal from './ReportVideoModal';

    
function VideoPage(){
  const location=useLocation();
  const video=location.state;
  const[userrating, setuserrating] = useState(0);
     
    
  const {isLoggedIn,isAdmin} = useContext(UserContext);
  const [showDeleteModal, setShowDeleteModal] = useState(false);

  const handleDeleteShow = () => setShowDeleteModal(true);
  const handleDeleteClose = () => setShowDeleteModal(false);
  
    
    return (
      <div className="content-container">
  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css"/>
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
          
            {video.rating}
  
  
          </div>
          <div className='video'>
            <iframe id='ytvideo' height='700' src={video.url} title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
          </div>
  
          <div className='uploader'>
            {video.uploader}
  
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

            {isAdmin && isLoggedIn && (
              <Button variant="danger" size="lg" className="report-video-button" onClick={() => handleDeleteShow(video)}>
                Report Video
              </Button>
            )}
          </div>

          {showDeleteModal && (<ReportVideoModal
                show={showDeleteModal}
                video={video}
                onHide={() => setShowDeleteModal(false)}
                showModal = {handleDeleteShow}
                closeModal = {handleDeleteClose}
        />
        )}
  
        </div>


    );

}

export default VideoPage;