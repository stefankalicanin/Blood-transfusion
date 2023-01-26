import React, {useState, useEffect}  from 'react' 
import { useNavigate } from "react-router-dom";
import axios from 'axios';


function BookAppointment(){
  const navigate = useNavigate();
  const [userInfo,setUserInfo] = useState([]);
  const [selectedItem,setSelectedItem] = useState([]);
  const [answers,setAnswers] = useState([]);
  const [userLoaded, setUserLoaded] = useState(false);
  const fetchData = async () => {
        const options = {
        method: 'GET',
        url: 'http://localhost:8084/api/appointment/getAllAvailable',
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
        };

        axios.request(options).then(function (response) {
        console.log(response.data);
        setAnswers(response.data);
        setUserLoaded(true)

        }).catch(function (error) {
        console.error(error);
        return { success: false };
        });
    }
    useEffect(() => {
      fetchData();
      }, []);

      const handleSave = () => {
        if (selectedItem) {
          // Do something with the selected item, for example, send it to an API
          console.log("Selected item:", selectedItem);

          const loggedInUser = JSON.parse(localStorage.getItem('user'));
          setUserInfo(loggedInUser.id.toString());
          console.log("User:",  userInfo.toString());
          const options = {
            method: 'PUT',
            url: 'http://localhost:8084/api/appointment/book/'+ selectedItem.toString() +'/' + userInfo.toString() + '/',
            headers: {
              Authorization: 'Bearer ' + localStorage.getItem('token')
            }
          };
          axios.request(options).then(function (response) {
            console.log(response.data);
            navigate("/centers")
          }).catch(function (error) {
            console.error(error);
            //navigate("/survey")
          });
        } else {
          console.log("No item selected");
        }
      };
      return (
    <div style={{'marginLeft':'280px'}}>
    {userLoaded ? (
       <div className="Neso">
         <h1>Lista slobodnih termina</h1>
         {answers.map((element, index)=>
         (
          <div className={index+1}>
            <p key={index+1}>{element.date  + "\t\t" + element.time}</p>
            <label>
            <input
              type="radio"
              name="same"
              value={element.id}
              key={index+1}
              onChange={() => setSelectedItem(element.id)}
              
            />
            Izaberi
          </label>
          </div>     
          )
         )
        }
         <button onClick={handleSave}>Rezervisi</button>
       </div>
    ) : (
      <p>No question found, please try again</p>
      //Mozda na stranicu 404?
    )}  
    </div>
      )
}
export default BookAppointment;