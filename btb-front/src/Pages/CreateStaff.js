import React, { useState,useEffect } from 'react'
import axios from 'axios'
import { eventWrapper } from '@testing-library/user-event/dist/utils';
import { toInteger } from 'lodash';

export default function CreateStaff() {

 
  
  const [centerList, setCenterList] = useState([{'name':'','id':'','address':'','description':'','grade':''}])
  const [centerId, setCenterId] = useState("");
  useEffect(() =>{
    const fetchData = async ()=>{
        const result = await axios.get('http://localhost:8084/api/center');
        setCenterList(result.data); 
    };
    fetchData();
}, [])

    const [staff, setStaff] = useState({
        jmbg: "",
        firstName: "",
        lastName: "",
        email:"",
        password:"",
        gender:"",
        phone:"",
        address:"",
        city:"",
        country:"",
        center_id: "",
        role: "STAFF",
      });
      const { jmbg,firstName,lastName,email,password,gender,phone,address,city,country,center_id } = staff;

      const onInputChange = (e) => {
        setStaff({ ...staff, [e.target.name]: e.target.value });       
      };
     
      const handleChange = event => {
        // setCenterId(event.target.value);
        setStaff({...staff, ["center_id"]:toInteger(event.target.value)});
      };

     
      const onSubmit = async (e) => {
        e.preventDefault();
        // staff.center_id=centerId;
        console.log("---------------")
        console.log(staff);
        await axios.post("http://localhost:8084/api/staff", staff);
      };
      
  return (
    <div className="container col-4 border rounded p-4 mt-2 shadow" style={{'width':'50%','margin-left':'280px'}}>
   <p></p>
     <h2 className="text-center m-4">Register staff</h2>
          <form  className='row g-2' onSubmit={(e) => onSubmit(e)}>
          <select className="form-control" onChange={handleChange} name="center">
              <option value="">Choose center name</option>

        {centerList.map((center,index) => (
          <option key={index} value={center.id}>
            {center.name}
          </option>    
              ))
              }

          </select>
            <div className="col md-6">
              <label htmlFor="Jmbg" className="form-label">
                Jmbg
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter jmbg"
                name="jmbg"
                pattern="[1-9][0-9]{12}"
                title="JMBG has 13 digit"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="col md-6">
              <label htmlFor="FirstName" className="form-label">
                First Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter first name"
                name="firstName"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div class="w-100"></div>
            <div className="col md-6">
              <label htmlFor="LastName" className="form-label">
                Last Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter last name"
                name="lastName"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="col-6">
              <label htmlFor="Email" className="form-label">
                Email
              </label>
              <input
                type={"email"}
                className="form-control"
                placeholder="Enter email"
                name="email"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div class="w-100"></div>
            <div className="col md-6">
              <label htmlFor="Passsword" className="form-label">
                Passsword
              </label>
              <input
                type={"password"}
                className="form-control"
                placeholder="Enter password"
                name="password"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="col md-6">
              <label htmlFor="Phone" className="form-label">
                Phone
              </label>
              <input
                type={"tel"}
                className="form-control"
                placeholder="Enter phone"
                name="phone"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div class="w-100"></div>
            <div className="col md-6">
              <label htmlFor="Address" className="form-label">
                Address
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter address"
                name="address"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="col md-6">
              <label htmlFor="City" className="form-label">
                City
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter city"
                name="city"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div class="w-100"></div>
            <div className="col-6 col-md-6">
              <label htmlFor="Country" className="form-label">
                Country
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter country"
                name="country"
                required
                onChange={(e) => onInputChange(e)}
              />
            </div>
            
           
            <div className="col-6 col-md-6" >
            <label htmlFor="Gender" className="form-label">
                Gender
              </label>
              <br/>
            <input type="radio" value="male" name="gender" onChange={(e) => onInputChange(e)}/> Male<br/>
            <input type="radio" value="female" name="gender" onChange={(e) => onInputChange(e)}/> Female
            </div>
            <div className='col -12'>
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            </div>

          </form>
        </div>
   
  );
}
