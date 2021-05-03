import {React,useState,useEffect} from "react";

import "../../styles/base.css"
import NavBar from "../../components/Navbar"
import UserMeta from "../../components/UserMeta"
import winnerImg from "../../assets/img/mockup/winner.jpeg"
import VoteComponent from "../../components/VoteComponent";
import Auth from "../../services/Auth";
import PictureApi from "../../api/PictureApi"


export default function VotingPage() {
   // Constants
 const API_URL ='https://my.api.mockaroo.com/user.json?key=ae007e80';

 //states
  const [users,setUsers] = useState([0]);
  const randomId = Math.floor(Math.random() * 25) ;
  const randomUser = users[randomId];
  


  // Methods
  //fetch data 
  useEffect(() => {
   fetch(API_URL)
     .then((response) => response.json())
     .then((json) => setUsers(json));  
 }, []);


 console.log(randomUser);

    return (
      <div className="general-container">
        <header>
          <NavBar onLogout={() => Auth.logout()}/>
        </header>


        { randomUser  === undefined && <p>Loading Data ...</p>}

        { randomUser !== undefined && 

        <main>
            <div className ="winner-content">
          <h1>Vote for this style ...</h1>
          <UserMeta users = {randomUser} /> 

          <div className="wrapper-img-square">
          <img id = "main-img" src={randomUser.pictures[0].url} alt="main-logo" />
        </div>
          <div className="under-img-container">
           <VoteComponent />
          </div>
            </div>
            
        </main>
        
    }


        <footer> Follow us | about SDA | About us </footer>
      </div>
    );
      
}
