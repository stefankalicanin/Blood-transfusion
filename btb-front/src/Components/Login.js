import React, {useState}  from 'react' 
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
import LoginCSS from './Login.module.css';


export default function LoginFunc(){
    const navigate = useNavigate();
    const [loggedUserInfo, setLoggedUserInfo] = useState();
    const [state,setStates] = useState(
      {
        email: "", 
        password:""});

    const onLoginClick = async () => {
        const userData = {
          email: state.email,
          password:  state.password
        };
        console.log("Login " + userData.email + " " + userData.password);
        console.log(userData);
    
        const options = {
          method: 'POST',
          url: 'http://localhost:8084/api/login', // /auth/login
          headers: {'Content-Type': 'application/json'},
          data: userData
        };

        
        try {
          // const response = await axios.post(`http://localhost:8084/api/login`, state);

          const response = await axios.post(`http://localhost:8084/auth/login`, state)

          if (response.status == 200) {
            console.log("-=--==-=--=--=-=-=-=-=-=-=-=-=-=-=-=-=-=")
            localStorage.setItem("token", response.data.accessToken)
            const userInfo = await axios.request(`http://localhost:8084/auth/me`, {
              method: 'GET',
              headers: {
                Authorization: 'Bearer ' + localStorage.getItem('token')
              }
            })

            if (userInfo.status == 200) {
              localStorage.setItem("user", JSON.stringify(userInfo.data))
            }
          }

          console.log(response.status)
          console.log("---------------")

          console.log(response.data);
          // localStorage.setItem('user', JSON.stringify(response.data));
          // alert("Success");
          navigate("/home");
          navigate(0);

        } catch (error) {
          console.log(error.response.data);
        }


        // await axios.request(options).then(function (response) {
        //   console.log(response.data);
        //   setLoggedUserInfo(response.data);
        //   // localStorage.setItem('user_id', response.data.id);
        //   localStorage.setItem('user', response.data);
        //   console.log("Succesfully logged in!");
        //   navigate("/home");
    
        // }).catch(function (error) {
        //   console.error(error);
        //   console.log("Invalid log in info!");
        // });
      };
      return (
        <div style={{'margin-left':'280px'}}>

        <Container>
        <Row>
          <Col md="4">
            <h1>Login</h1>
            <Form>
              <Form.Group controlId="emailId"  >
                <Form.Label>Email</Form.Label> 
                <Form.Control
                  type="email"
                  name="email"
                  placeholder="Email adress"
                  value={state.email}
                  //onChange={onChangeFunc}
                  onChange={e=> setStates({...state, email: e.target.value})}
                  />
                <FormControl.Feedback type="invalid"></FormControl.Feedback>
              </Form.Group>

              <Form.Group controlId="passwordId">
                <Form.Label>Your password</Form.Label>
                <Form.Control
                  type="password"
                  name="password"
                  placeholder="Enter password"
                  value={state.password}
                  //onChange={onChangeFunc}
                  onChange={e=> setStates({...state, password: e.target.value})}
                  />
                <Form.Control.Feedback type="invalid"></Form.Control.Feedback>
              </Form.Group>
            </Form>
            <Button className="btn my-2" color="primary" onClick={onLoginClick}>
               Login
            </Button>
            <p className="mt-2">
              Don't have account? <Link to="/signup">Signup</Link>
            </p>
          </Col>
        </Row>

    </Container>
    </div>
      )
}