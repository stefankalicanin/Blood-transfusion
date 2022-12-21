import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router";
import { Link } from "react-router-dom";

var CONFIG = require("../Config/server.json");

function UserSurveys() {

    const { state } = useLocation()
    const navigate = useNavigate()

    const [report, setReport] = useState(
        {
            user_id: state?.data.user.id,
            appointment_id: state?.data.appointment.appointment_id,
            attendanceStatus: "",
            bloodType: 8,
            bloodQuantity: "0",
            doctorsNote: "",
            equipmentQuantity: "0"
        }
    )

    const [surveys, setSurveys] = useState([]);

    useEffect(() => {
        if (!localStorage.getItem('token') || !localStorage.getItem('user')){
            navigate("/login")
        }
        const user = JSON.parse(localStorage.getItem('user'))
        if (user['role'] != "STAFF") {
          navigate("/")
        }
        fetchSurveyData();
    }, [])
    
    console.log(state)
    console.log("-------")
    console.log(state?.data)

    const fetchSurveyData = async() => {
        try {
            const user_id = state?.data.user.id;
            const response = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/answers/${user_id}`, {
                headers: {
                  'Authorization': 'Bearer ' + localStorage.getItem('token')
                }});
            console.log(response.data)

            setSurveys(response.data);
        } catch (error) {
            // console.log(error.response);
            console.log("error")
            // navigate('/reports',
            // {
            //     state: {
            //         state
            //     }
            // });
        }
    }

    const missedAppointment = async (e) => {
        e.preventDefault();

        report.attendanceStatus = 1
        setReport({...report, "attendanceStatus":1})

        axios.post(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/report`, report, {
            headers: {
              'Authorization': 'Bearer ' + localStorage.getItem('token')
            }})
            .then(res => {
                console.log(res);
                console.log(res.data);
                navigate("/allUsers");
            })
            .catch(error => {
                console.log(error);
            })
        
    }

    const rejectedAppointment = async (e) => {
        e.preventDefault();

        report.attendanceStatus = 2
        setReport({...report, "attendanceStatus":2})

        axios.post(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/report`, report, {
            headers: {
              'Authorization': 'Bearer ' + localStorage.getItem('token')
            }})
            .then(res => {
                console.log(res);
                console.log(res.data);
                navigate("/allUsers");
            })
            .catch(error => {
                console.log(error);
            })   
    }

    const continueReport = async (e) => {
        e.preventDefault();
        // const data = {
        //     "user": state?.data.user,
        //     "appointment"
        // }
        // console.log(state?.data)
        const data = state?.data
        navigate('/reports/create', 
        {
            state: {
                data
            }
        })
    }
    // console.log(report)



    

    return (
        <div className='container'>
            <div className='py-4' style={{'width':'75%','margin-left':'280px'}}>
                {/* <input type="text" name="name" className="form-control" onChange={(e)=>handleSearch(e)} placeholder="search..."/><br/> */}
                <table className="table table-hover border rounded p-4 mt-2 shadow table-striped" style={{'cursor': 'pointer'}}>
                    <thead>
                        <tr className='table-dark'>
                        {/* <th scope="col"></th> */}
                        <th scope="col">QUESTION</th>
                        <th scope="col">ANSWER</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                        surveys.map((survey,index)=>(
                        <tr className='table-light'>
                            <td>{survey.question}</td>
                            <td>{survey.answer === true ? "yes" : "no"}</td>
                        </tr>
                        ))
                        }
                    </tbody>
                </table>
            </div>
            <button className='remove-btn update-btn'  style={{'color':'red'}} onClick={missedAppointment} >Missed</button>   
            <button className='remove-btn update-btn' style={{'margin-left':'10px'}} onClick={rejectedAppointment} >Reject</button>   
            <button className=" update-btn mx-2" style={{'color':'green'}} onClick={continueReport}>Continue </button>

        </div>
    )
}

export default UserSurveys;