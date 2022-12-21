import React, { useEffect, useState } from 'react'
import { useForm ,} from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as Yup from 'yup'
import axios from 'axios'
import { useNavigate } from 'react-router'
export default function ChangeAdminPassword() {
  

    const [adminDto,setAdminDto]=useState(
      {
        id:10,
        password:""
      }
    )
      const [passwordShown,setPasswordShown]=useState(false);
    const {id,password}=adminDto;

    const onInputChange = (e) => {
      setAdminDto({ ...adminDto, [e.target.name]: e.target.value });
    };
    const onSubmit = async (e) => {
      e.preventDefault();
      await axios.put("http://localhost:8084/api/admin/update", adminDto, {
        headers: {
          'Authorization': 'Bearer ' + localStorage.getItem('token')
        }
      });
      
    };

    const navigate = useNavigate();

    useEffect(()=>{
      if (!localStorage.getItem('token') || !localStorage.getItem('user')){
        navigate("/login")
      }
      const user = JSON.parse(localStorage.getItem('user'))
      if (user['role'] != "ADMIN") {
        navigate("/")
      }
  },[])
    
  const togglePassword = () => {

    setPasswordShown(!passwordShown);
  };
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Please change password</h2>
      <form form onSubmit={(e) => onSubmit(e)}>
      <div className="mb-3">
          <label>Password</label>
          <input
            name="password"
            type={passwordShown ? "text" : "password"}
            className="form-control" 
            onChange={(e) => onInputChange(e)}
          />
         
        </div>
        <div className="mb-3">
          <label>Confirm Password</label>
          <input
            name="confirmPwd"
            type={passwordShown ? "text" : "password"}
          
            className="form-control"
          />
        <label>
        <input type="checkbox" onClick={togglePassword} />
       Show password
      </label>
         
        </div>
        <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
      </form>
    </div>
    </div>
    </div>
  )
}