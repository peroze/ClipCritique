import './App.css';import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faMusic } from '@fortawesome/free-solid-svg-icons';
import Footer from './Components/Footer';
import VideoPage from './Components/VideoPage';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import MenuBar from './Components/MenuBar';



function App() {

    return(<div className="App p-1" > 
    

    <Router>
      <header>
        <MenuBar>
          
        </MenuBar>
      </header>
      <Routes>
      <Route exact path="/" element={<VideoPage />} />
      </Routes>
    </Router>
    <Footer>

    </Footer>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    </div>);
}
export default App;