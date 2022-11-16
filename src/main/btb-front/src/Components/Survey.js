import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import { Countries } from "./Countries"

const Survey = props => {
  const navigate = useNavigate();
  const [userInfo,setUserInfo] = useState([]);
  const [answers,setAnswers] = useState([]);
    const onChangeTrue = e => {
      answers[e].answer = true;
      };
    const onChangeFalse = e => {
        answers[e].answer = false;
      };
  const [userLoaded, setUserLoaded] = useState(false);

  const fetchUser = async () => {
    try {
      const options = {method: 'GET'};
      let response = await fetch('http://localhost:8084/api/questions', options);
      let json = await response.json();
      //console.log(json)
      return { success: true, data: json };
    } catch (error) {
      console.log(error);
      return { success: false };
    }
  }
  useEffect(() => {
    const loggedInUser = localStorage.getItem('user_id');
    if (loggedInUser) {
      const foundUser = JSON.parse(JSON.stringify(loggedInUser));
      setUserInfo(foundUser);
    }
    else{
      //Link to login page - no user found.
    }
  }, []);
  useEffect(() => {
    (async () => {
      setUserLoaded(false);
      let res = await fetchUser();
      if (res.success) {
        setUserLoaded(true);
        setAnswers(res.data);  
      }
    })();
  }, []);
  const submitAnswers=()=>{
    //console.log(answers);
    const user_id_value = userInfo.toString();

    answers.user_id = user_id_value;
    var viewData = { 
      "user_id" : "",
      "answers" : {}
    };
    viewData.user_id = userInfo.toString();
    const answers_data ={user_id:userInfo, answers:{}}
    for(const index in answers){
      if(answers[index].answer == null){continue;}
      var string_num = answers[index].id.toString();
      answers_data.answers[string_num] = answers[index].answer;
      viewData.answers[string_num] = answers[index].answer;

    }
    const options = {
      method: 'POST',
      url: 'http://localhost:8084/api/answers',
      headers: {'Content-Type': 'application/json'},
      data:viewData
    };
    axios.request(options).then(function (response) {
      console.log(response.data);
      navigate("/home")
    }).catch(function (error) {
      console.error(error);
    });
    // const options = {
    //   method: 'POST',
    //   headers: {'Content-Type': 'application/json'},
    //   body: JSON.stringify(viewData)//'{"user_id":"10","answers":{"1":false,"2":false,"3":false}}'//viewData.toString()
    // };
  
    // fetch('http://localhost:8084/api/answers', options)
    // .then(response => response.json())
    // .then(response => console.log(response))
    // .catch(err => console.error(err));
  }
  return (
    <div style={{'margin-left':'280px'}}>
    {userLoaded ? (
       <div className="Neso">
         {answers.map((element, index)=>
         (
          <div className={index+1}>
            <p key={index+1}>{index + "." + element.question }</p>
            <label>
            <input
              type="radio"
              value="da"
              name={index+1}
              key={index+1}
              onClick={() => onChangeTrue(index)}
            />
            Da
          </label>
          <label>
            <input
              type="radio"
              value="ne"
              name={index+1}
              key={index+1}
              onClick={() => onChangeFalse(index)}
            />
            Ne
          </label>
          </div>     
          )
         )
        }
         <button onClick={submitAnswers}>Add</button>
       </div>
    ) : (
      <p>No question found, please try again</p>
      //Mozda na stranicu 404?
    )}
  </div>
  );
}
export default Survey;