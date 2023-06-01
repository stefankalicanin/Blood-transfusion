import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';

var CONFIG = require("../Config/server.json");

function Reports() {

    const { state } = useLocation()
    const navigate = useNavigate()

    useEffect(() => {
      if (!localStorage.getItem('token') || !localStorage.getItem('user')){
        navigate("/login")
      }
      const user = JSON.parse(localStorage.getItem('user'))
      if (user['role'] != "STAFF") {
        navigate("/")
      }
    }, [])
    
    const [appointments, setAppointments] = useState([]);
    const [loading, setLoading] = useState(true)
    // const data = location.state?.data;

    // console.log(data);
    // console.log(location.state)
    
    // const [searchParams] = useSearchParams();
    // const userId = searchParams.get("userId")

    useEffect(() => {
        fetchData();
    }, [])


    // console.log(state?.data)
    console.log(appointments)

    const fetchData = async() => {
        try {
            const user_id = state?.data.id;
            const loadedScheduledAppointments = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/schedule/${user_id}`, {
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token')
                }})
                console.log(loadedScheduledAppointments.data)
            
            // loadedScheduledAppointments.data = [...loadedScheduledAppointments.data].sort((a, b) => 
            // new Date(...a.date.split('-').reverse()) - new Date(...b.date.split('-').reverse()));

            loadedScheduledAppointments.data = loadedScheduledAppointments.data.sort((a, b) => 
            a.date.localeCompare(b.date) || a.time.localeCompare(b.time));

            setAppointments(loadedScheduledAppointments.data);
            setLoading(false);
        } catch (error) {
            console.log(error.response);
            navigate('/allUsers');
        }
    }

    if (loading) {
        return (<div style={{
            'margin-left': '280px', 
            'margin-top': '50px',
            'font-size': '2rem',
        }}><h2></h2></div>)
    }

    // const searchParams = new URLSearchParams(search);

    const handleRowClick = async (appointment) => {
        const prevData = state?.data;
        const data = {
            "user": prevData,
            "appointment": appointment
        }
        navigate('/user/survey/answers',
        {
            state: {
                data
            }
        })
    }

    // console.log(userId);

    return (
        <div className='container'>
            <div className='py-4' style={{'width':'75%','margin-left':'280px'}}>
                {/* <input type="text" name="name" className="form-control" onChange={(e)=>handleSearch(e)} placeholder="search..."/><br/> */}
                <table className="table table-hover border rounded p-4 mt-2 shadow table-striped" style={{'cursor': 'pointer'}}>
                    <thead>
                        <tr className='table-dark'>
                        {/* <th scope="col"></th> */}
                        <th scope="col">CENTER</th>
                        <th scope="col">STAFF</th>
                        <th scope="col">DATE</th>
                        <th scope="col">TIME</th>
                        <th scope="col">DUR [h]</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                        appointments.map((appointment,index)=>(
                        <tr className='table-light' onClick={() => handleRowClick(appointment)}>
                        <td>{appointment.centerName}</td>
                        <td>Dr. {appointment.staffFirstName} {appointment.staffLastName}</td>
                        <td>{appointment.date}</td>
                        <td>{appointment.time}</td>
                        <td>{appointment.duration}</td>
                        </tr>
                        ))
                        }
                    </tbody>
                </table>
                <p style={{'margin-left':'676px', 'margin-top':'20px'}}>Click on row to select the appointment</p>
            </div>
        </div>
    )
}

export default Reports;