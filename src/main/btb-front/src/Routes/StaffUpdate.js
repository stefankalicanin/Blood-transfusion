import React, { useState,useEffect } from 'react'
import axios from 'axios'

var CONFIG = require("../Config/server.json");


function StaffUpdate() {

    const onInputChange = (e) => {
        setStaff({ ...staff, [e.target.name]: e.target.value });
    };
    
    const onSubmit = async (e) => {
        e.preventDefault();

        
        if (staff.password !== "" | staff.repeatPassword !== ""){
            console.log("ok")
            console.log(staff);
            if (staff.password !== staff.repeatPassword) {
                console.log("ok1")
                alert("Passwords aren't matching")
                return;
            }
        }

        await axios.put(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/staff/${staff.id}`, staff);
    };

    const[staff, setStaff] = useState({
        id:"",
        jmbg:"",
        firstName:"",
        lastName:"",
        email:"",
        password:"",
        repeatPassword:"",
        address:"",
        phone:"",
        city:"",
        country:"",
        center_id:""
    })

    const loadStaffInfo = async () => {
        try {
            const loadedStaff = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/staff/1`);
            setStaff(loadedStaff.data);
            sessionStorage.setItem('staffInfo', JSON.stringify(loadedStaff.data));
        } catch (error) {
            console.log(error.response.data);
        }
    }

    useEffect(() => {
        loadStaffInfo();
    }, [])

    // console.log(staff);
      
    return (
    <div className="container col-4 border rounded p-4 mt-2 shadow" style={{'width':'50%', 'margin-left':'27%'}}>
    <p></p>
        <h2 className="text-center m-4">Update Profile</h2>
            <form  className='row g-2' onSubmit={(e) => onSubmit(e)}>

                <div className="col md-6">
                <label htmlFor="Jmbg" className="form-label">
                    Jmbg
                </label>
                <input
                    type={"text"}
                    className="form-control"
                    value={staff.jmbg}
                    name="jmbg"
                    pattern="[1-9][0-9]{12}"
                    title="JMBG has 13 digit"
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
                    value={staff.firstName}
                    name="firstName"
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
                    value={staff.lastName}
                    name="lastName"
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
                    value={staff.email}
                    name="email"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                <div class="w-100"></div>
                <div className="col md-6">
                <label htmlFor="Passsword" className="form-label">
                    New Passsword
                </label>
                <input
                    type={"password"}
                    className="form-control"
                    placeholder="Enter password"
                    name="password"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                <div className="col md-6">
                <label htmlFor="Passsword" className="form-label">
                    Repeat Passsword
                </label>
                <input
                    type={"password"}
                    className="form-control"
                    placeholder="Enter password"
                    name="repeatPassword"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                <div className='col md-6'>

                <label htmlFor="Phone" className="form-label">
                    Phone
                </label>
                <input
                    type={"tel"}
                    className="form-control"
                    value={staff.phone}
                    name="phone"
                    onChange={(e) => onInputChange(e)}
                    />
                </div>
                <div class="w-100"></div>
                <div className="col md-6">
                <label htmlFor="City" className="form-label">
                    City
                </label>
                <input
                    type={"text"}
                    className="form-control"
                    placeholder="Enter city"
                    value={staff.city}
                    name="city"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                <div className="col md-6">
                <label htmlFor="Country" className="form-label">
                    Country
                </label>
                <input
                    type={"text"}
                    className="form-control"
                    value={staff.country}
                    placeholder="Enter country"
                    name="country"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                {/* <div class="w-100"></div> */}
                <div className="col-6">
                <label htmlFor="Address" className="form-label">
                    Address
                </label>
                <input
                    type={"text"}
                    className="form-control"
                    value={staff.address}
                    name="address"
                    onChange={(e) => onInputChange(e)}
                />
                </div>
                {/* <div className="col-6 col-md-3" >
                <label htmlFor="Status" className="form-label">
                    Status
                </label>
                <br/>
                <input type="radio"  value="true" name="status" onChange={(e) => onInputChange(e)}/> Active<br/>
                <input type="radio" value="false" name="status" onChange={(e) => onInputChange(e)}/> Not active
                </div> */}
            
                <div className='col-12'>
                <button type="submit" className="btn btn-outline-primary" style={{'width':'150px', 'height':'50px', 'margin-left':'40%', 'margin-top':'25px'}}>
                Submit
                </button>
                </div>

            </form>
            </div>
    
    
    );

}

export default StaffUpdate;