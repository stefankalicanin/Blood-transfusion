import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { EditCenterData } from '../Components/EditCenterData';
// import EditCenterInfo from '../pages/EditCenterInfo';
// import { Button } from 'react-bootstrap';
import "bootstrap/dist/css/bootstrap.min.css";

import _ from 'lodash';

// import "../App.css"
import "../Utils/center.css";

var CONFIG = require("../Config/server.json");

function EditCenter() {
    // const[index, setIndex] = useState(1);
    // console.log(index)
    const[toggleState, setToggleState] = useState('1');
    const toggleTab = (index) => {
        setToggleState(index);
    }


    const[loading, setLoading] = useState(true);
    const[error, setError] = useState(false);
    const[errorStatus, setErrorStatus] = useState(0);

    const[center, setCenter]=useState({
        name:"",
        address:"",
        description:"",
        grade:"",
        availableAppointments: [],
        amountOfBlood: [],
        staff: []
    })

    const[appointments, setAppointments] = useState({
        id:"",
        date:"",
        time:"",
        duration:"",
        staff_id:"",
        staffFirstName:"",
        staffLastName:""
    })

    const[staffs, setStaffs] = useState({
        id:"",
        jmbg:"",
        firstName:"",
        lastName:"",
        email:"",
        address:"",
        phone:""
    })

    const[toDeleteAppointments, updateDeleteAppointmentIDs] = useState([])

    
    // console.log(CONFIG.IP_ADDRESS + ":" + CONFIG.PORT);
    
    useEffect(() => {
        loadCenter()
    }, [])

    const loadCenter =  async () => {
        // const loadedCenter = await axios.get(`http://localhost:8084/center/${id}`)
        // console.log("Usao u load async");
        try {
            const loadedCenter = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/center/1`);
            const loadedAppointments = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/appointment/byCenter/1`)
            const loadedStaff = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/staff/byCenter/1`)
            
            loadedAppointments.data = [...loadedAppointments.data].sort((a, b) => a.id - b.id);

            setCenter(loadedCenter.data);
            setAppointments(loadedAppointments.data);
            setStaffs(loadedStaff.data);

            setLoading(false);

            // setTimeout(async () => {
            //     setLoading(false);
            // }, 0);
            sessionStorage.setItem('center', JSON.stringify(loadedCenter.data));
            sessionStorage.setItem('appointments', JSON.stringify(loadedAppointments.data));
        } catch (error) {
            console.log(error.response.data);
            setError(true);
            setLoading(false);
            setErrorStatus(error.response.data);
        }
        // console.log("Izasao iz load");
        // if loadedCenter.     
    }

    // console.log(appointments);

    if (loading) {
        return (<div style={{
            'margin-left': '280px', 
            'margin-top': '50px',
            'font-size': '2rem',
        }}><h2>Loading...</h2></div>)
    }

    if (error) {
        return (<div style={{
            'margin-left': '280px', 
            'margin-top': '30px',
            'font-size': '3rem',
        }}>Error {errorStatus.status}...</div>);
    }

    const updateCenter = async (e) => {
        e.preventDefault();
        // console.log(e);
        // console.log(center);

        const updatedCenter = {
            'name': center.name,
            'address': center.address,
            'description': center.description
        }

        let keysToUpdate = ['name', 'address', 'description'];

        let exitError = false;

        let seshCenter = JSON.parse(sessionStorage.getItem('center'));

        if (_.isEqual(seshCenter, center)) {
            console.log("SAME")
            return;
        }

        Object.keys(updatedCenter).forEach(function(key) {
            if (keysToUpdate.includes(key)) {
                if (updatedCenter[key] === "") {
                    updatedCenter[key] = seshCenter[key];
                    // exitError = true;
                }
            }
        });
        if (exitError) { return; }

        try {
            const response = await axios.put(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/center/1`, updatedCenter);
            console.log(response);
            // setCenter((center) => {
            //     return { ...center, ...{updatedCenter}}
            // })

            Object.keys(updatedCenter).forEach(function(key) {
                console.log("Key: ", key);
                console.log("Val: ", updatedCenter[key]);
                setCenter({ ...center, [key]:updatedCenter[key]})
            });

            sessionStorage.setItem('center', JSON.stringify(center));

        } catch (error) {
            console.log(error);
        }
    }

    const checkChecked = (id) => {
        var indexOfCheck = toDeleteAppointments.indexOf(id);

        if (indexOfCheck !== -1) {
            return true;
        }
        return false;
    }

    const onCheckChange = (e) => {
        var indexToRemove = toDeleteAppointments.indexOf(parseInt(e.target.value));

        if (indexToRemove !== -1) {
            updateDeleteAppointmentIDs(toDeleteAppointments.filter(item => item !== parseInt(e.target.value)))
        } else {
            updateDeleteAppointmentIDs([...toDeleteAppointments, parseInt(e.target.value)])
        }
    }


    const deleteCenters = (e) => {
        e.preventDefault();
        
        if (toDeleteAppointments.length === 0) {
            return;
        }
        else {
           axios.request({
                method: 'DELETE',
                url: `http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/appointment/delete/multiple`,
                headers: {'Content-Type': 'application/json'},
                data: toDeleteAppointments
            }).then(function (response) {
                setAppointments(appointments.filter(item => toDeleteAppointments.includes(item.id) === false))
                updateDeleteAppointmentIDs([]);
                console.log(response.data);
            }).catch(function (error) {
                console.error(error);
            });

            

        }
    }


    console.log(toDeleteAppointments)

    const appointmentRows = appointments.map((info) => {
            // center.availableAppointments = [...center.availableAppointments].sort((a, b) => a.id - b.id);
            return (
                <tr className='table-light'>
                    <td><input 
                         className='form-check-input'
                         type="checkbox"
                         name={info.id}
                         value={info.id}
                         checked={checkChecked(info.id)}
                         onChange={(e) => onCheckChange(e)}
                        //  defaultChecked={info.staff_id == "Yes" ? true : false}
                         /></td>
                    {/* <td>{info.id}</td> */}
                    <td>{info.date}</td>
                    <td>{info.time}</td>
                    <td>{info.duration}</td>
                    <td>{"Dr. " + info.staffFirstName + " " + info.staffLastName}</td>
                    
                </tr>
            )
        });
    
        const staffRows = staffs.map((info) => {
            return (
                <tr className='table-light'>
                    <td>{info.jmbg}</td>
                    <td>{info.firstName}</td>
                    <td>{info.lastName}</td>
                    <td>{info.email}</td>
                    <td>{info.address}</td>
                    <td>{info.phone}</td>
                </tr>
            )

        })
    // console.log(center)

    return (
        <div className='edit-center'>

            <div className='edit-center-page'>
                <div className='nesto'>
                    <p className='title'>Settings</p>
                    <p className='subTitle'>Edit Center {center.name}</p>
                    {/* <p>Edit Center</p> */}
                    <div className='settings-items'>
                        <ul className='settings-items'>
                            {EditCenterData.map((item, index) => {
                                return (
                                    <li 
                                    key={index} 
                                    // className={toggleState === item.index ? (item.cName + " active-tab") : item.cName}
                                    className={item.cName}
                                    onClick={() => toggleTab(item.index)}>
                                        <Link className={toggleState === item.index ? (item.cName + " active-tab") : item.cName} >{item.title}</Link>
                                    </li>
                                    
                                )
                            })}

                            {/* <Link to="#"><li className='settings-text'>Info</li></Link>
                            <li className='settings-text'>Appointments</li>
                        <li className='settings-text'>Staff</li> */}
                            
                        </ul>
                    </div>
                    {/* <hr className='hr-edit'/> */}
                </div>
                <hr className='hr-edit'/>
            </div>
            <div className='content-tabs'>
                <div 
                id='info'
                className={toggleState === '1' ? "content active-content" : "content"}>
                    <form className='info-content'>
                        <label id="name">Name:</label>
                        <input maxLength={30} type={"text"} name="name" className='name-input' defaultValue={center.name} 
                            // onChange={(e) => center.name = e.target.value}
                            onChange={(e) => center.name=e.target.value }
                        /> 
                        <label id="address">Address:</label>
                        <input minLength={1} maxLength={255} type={"text"} name="address" className='address-input' defaultValue={center.address} 
                            onChange={(e) => center.address=e.target.value }
                        /> <br/><br/>
                        <label id="description">Description:</label> <br/>
                        <textarea maxLength={255} type={"text"} name="description" className='description-input' defaultValue={center.description} 
                            onChange={(e) => center.description=e.target.value }
                        /> <br/><br/>
                        
                        <button className='update-btn' onClick={updateCenter}>
                            Update
                        </button>
                    </form>
                </div>
                <div className={toggleState === '2' ? "container content active-content" : "content"} style={{'width':'70%', 'margin-left':'-70px'}}>
                    <form className='appointment-content'>

                        {/* <table className='table-appointments'> */}
                        <div className='py-4'>

                        <table id='appTable' className='table table-hover border rounded p-3 mt-1 shadow table-striped'>
                            <thead className='table-dark'>
                                <tr>
                                    <th scope='col'></th>
                                    <th scope='col'>Date</th>
                                    <th scope='col'>Time</th>
                                    <th scope='col'>Duration [h]</th>
                                    <th scope='col'>Staff</th>
                                </tr>
                                {/* <th>Select</th> */}
                            </thead>
                            <tbody className='table-content'>
                                {appointmentRows}
                            </tbody>
                        </table>
                        </div>
                        <button className='remove-btn update-btn' onClick={deleteCenters} >Remove</button>
                    </form>
                </div>
                <div className={toggleState === '3' ? "container content active-content" : "content"} style={{'width':'70%', 'margin-left':'-70px'}}>
                        <div className='py-4'>
                        <table id='staffTable' className='table table-hover border rounded p-3 mt-1 shadow table-striped'>
                            <thead className='table-dark'>
                                <tr>
                                    <th scope='col'>JMBG</th>
                                    <th scope='col'>Firstname</th>
                                    <th scope='col'>Lastname</th>
                                    <th scope='col'>Email</th>
                                    <th scope='col'>Address</th>
                                    <th scope='col'>Phone</th>
                                </tr>
                                {/* <th>Select</th> */}
                            </thead>
                            <tbody className='table-content'>
                                {staffRows}
                            </tbody>
                        </table>
                        </div>
                </div>
            </div>
        </div>
    );
}

export default EditCenter;