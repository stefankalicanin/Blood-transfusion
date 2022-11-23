import React, {useState, useEffect} from 'react'
import axios from 'axios'
import { toInteger } from 'lodash';

export default function DefineAppointment() {

    const [staffList, setStaffList] = useState([{'id':'', 'firstName':'', 'lastName':'' }])
    const [staffId, setStaffId] = useState("");
    useEffect(() => {
        const fetchData = async () => {
            const userInfo = JSON.parse(localStorage.getItem('user'));
            console.log(userInfo);
            const result = await axios.get('http://localhost:8084/api/staff/byCenter/' +userInfo.center_id);
            setStaffList(result.data);
        };
        fetchData();
    }, [])



    const [appointment, setAppointment] = useState({
        date: "",
        time: "",
        duration: "",
        staff_id: ""
        
    });
    


    const onInputChange = (e) => {
        setAppointment({...appointment, [e.target.name]: e.target.value});
    }

    const handleChange = event => {
        setAppointment({...appointment, ["staffId"]:toInteger(event.target.value)});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        console.log("---------")
        console.log(appointment);
        appointment.time = appointment.time + ":00";
        await axios.post("http://localhost:8084/api/appointment/createAppointment", appointment);
    };

    

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Create an Appointment</h2>
          <form  onSubmit={(e) => onSubmit(e)} >
            <div className="mb-3">
              <label htmlFor="Date" className="form-label">
                Date:
              </label>
              <input
                type={"date"}
                className="form-control"
                name="date"  
                required
                onChange={(e) => onInputChange(e)} 
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Time" className="form-label">
                Time:
              </label>
              <input
                type={"time"}
                className="form-control"
                name="time" 
                required
                onChange={(e) => onInputChange(e)}    
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Duration" className="form-label">
                Duration:
              </label>
              <input
                type={"number"}
                className="form-control"
                placeholder="Enter duration"
                name="duration"               
                required
                onChange={(e) => onInputChange(e)}            
              />
            </div>
            <div className="mb-3">
                <label htmlFor="Staff" className="form-label">
                    Staff:
                </label>
                
                <select className="form-control" onChange={handleChange} name ="staff">
                    <option value="">Choose staff</option>
                    {staffList.map((staff, index) => (
                        <option key={index} value={staff.id}>
                            {staff.firstName} {staff.lastName}
                        </option>
                    ))}
                </select>
            </div>
           
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
