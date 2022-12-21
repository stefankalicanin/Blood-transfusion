import React, { useEffect, useState } from 'react'
import axios from 'axios'
import {  useNavigate } from "react-router-dom";

export default function CreateCenter() {
    
    const navigate = useNavigate();
  
    useEffect(() => {
      if (!localStorage.getItem('token') || !localStorage.getItem('user')){
        navigate("/login")
      }
      const user = JSON.parse(localStorage.getItem('user'))
      if (user['role'] != "ADMIN") {
        navigate("/")
      }
    }, [])

    const [center, setCenter] = useState({
        name: "",
        address: "",
        description: "",
        grade:0.0,
      });

      const { name, address, description, grade } = center;

      const onInputChange = (e) => {
        setCenter({ ...center, [e.target.name]: e.target.value });
      };
    
      const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8084/api/center", center, {
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
          }});
        
      };


  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Create center</h2>
          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name:
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter name..."
                name="name"
                value={name}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Adress" className="form-label">
                Address:
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter address..."
                name="address"
                value={address}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Description" className="form-label">
                Description:
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter description..."
                name="description"
                value={description}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            {/* <div className="mb-3">
              <label htmlFor="Grade" className="form-label">
                Grade:
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter grade..."
                name="grade"
                min="1"
                max="5"
                value={grade}
                required
                onChange={(e) => onInputChange(e)}
              />
            </div> */}
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
