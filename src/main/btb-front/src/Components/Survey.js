import React, { useEffect, useState } from 'react';

const Survey = props => {

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
    answers.user_id = userInfo;
    const answers_data ={user_id:userInfo, answers:[]}
    for(const index in answers){
      if(answers[index].answer == null){continue;}
      answers_data.answers[answers[index].id] = answers[index].answer; 
    }
    console.log(answers_data);
    console.log(answers_data.answers.length);
  }
  return (
    <div>
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