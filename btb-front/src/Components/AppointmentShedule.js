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
import LoginCSS from './Login.module.css';


export default function AppointmentSheduleFunc(){
    const btnstyle = {
        color: "white",
        backgroundColor: "DodgerBlue",
        padding: "10px",
        fontFamily: "Arial",
        fontSize:"18px",
        //display:"flex",
        
      };

    const [centers, setCenters] = useState([]);
    const [first, setFirst] = useState(true);
    const [chosenAppointment,setChosenAppointment] = useState(-1);

    const [searchFilter, setSearchFilter] = useState({
        date : "",
        time : "",
        duration : ""
    });

    useEffect(() => {
        if (first){
            loadCenters();
            setFirst(!first);
        }
    }, []);

    const loadCenters = async () => {
        const options = {method: 'GET', url: 'http://localhost:8084/api/appointment/findAllAvailable'};

        axios.request(options).then(function (response) {
        console.log(response.data);
        setCenters(response.data);
        }).catch(function (error) {
        console.error(error);
        });
    };

    const onInputChange = (e) => {
        setSearchFilter({ ...searchFilter, [e.target.name]: e.target.value });
    };
    const onChangeRadioButton = e => {
        setChosenAppointment(e);
        };
    const onSubmitClick = async () => {

        console.log(chosenAppointment)
    };

    return (
      <div style={{'margin-left':'280px','margin-right':'40px'}}>
        <div className='py-4'>
            <table className="table border rounded p-4 mt-2 shadow table-striped" >
                <thead>
                    <tr className='table-dark'>
                        <th scope="col"></th>
                        <th scope="col">Date</th>
                        <th scope="col">Time</th>
                        <th scope="col">Duration</th>
                        <th scope="col">Chose One</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        centers.map((center,index)=>(
                            <tr className='table-light'>
                                <td scope="row">{index+1}</td>
                                <td>{center.date}</td>
                                <td>{center.time}</td>
                                <td>{center.duration}h</td>
                                <td><label>
                                    <input
                                    type="radio"
                                    value="shedule"
                                    name="shedule"
                                    key={index+1}
                                    onChange={() => onChangeRadioButton(index+1)}
                                    />
                                </label></td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
            <div onClick={onSubmitClick}>
            <a style={btnstyle}>
               Submit
            </a>
            </div>
        </div>
    </div>
      )
}