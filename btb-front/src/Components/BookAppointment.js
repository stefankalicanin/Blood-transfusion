import React, {useState, useEffect}  from 'react' 
import {
    Container,
    Button,
    Row,
    Col,
    Form,
    FormControl
  } from "react-bootstrap";
import axios from 'axios';
import { Link, Navigate, Route, Routes, useNavigate } from "react-router-dom";


export default function BookAppointment(){
    const [answers,setAnswers] = useState([]);
    const [userLoaded, setUserLoaded] = useState(false);
  const fetchUser = async () => {
    try {
      const options = {method: 'GET', headers: {
        'Authorization': 'Bearer ' + localStorage.getItem('token')
      }};
      let response = await fetch('http://localhost:8084/api/appointment/getAllAvailable', options);
      let json = await response.json();
      console.log(json)
      return { success: true, data: json };
      
    } catch (error) {
      console.log(error);
      return { success: false };
    }
  }
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
      return (
        <div style={{'margin-left':'280px'}}>
Hello
    </div>
      )
}