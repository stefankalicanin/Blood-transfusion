import axios from "axios";
import { toInteger } from "lodash";
import { useState } from "react";
import { FaIcons } from "react-icons/fa";
import { useLocation, useNavigate } from "react-router";
import Select from "react-select";

// import { FcSurvey } from "react-icons/fc";
import { RiSurveyLine } from "react-icons/ri";
import { Link } from "react-router-dom";

var CONFIG = require("../Config/server.json");

function ReportsCreate() {
    
    const { state } = useLocation();

    const navigate = useNavigate();

    console.log(state?.data)


    const [report, setReport] = useState(
        {
            user_id: state?.data.user.id,
            appointment_id: state?.data.appointment.appointment_id,
            attendanceStatus: "",
            bloodType: "",
            bloodQuantity: "",
            doctorsNote: "",
            equipmentQuantity: ""
        }
    )
    // console.log(state?.data);
    console.log(report);

    const [equipment, setEquipment] = useState({})

    const optionList = [
        { value: "0", label: "A+"},
        { value: "1", label: "A-"},
        { value: "2", label: "B+"},
        { value: "3", label: "B-"},
        { value: "4", label: "0+"},
        { value: "5", label: "0-"},
        { value: "6", label: "AB+"},
        { value: "7", label: "AB-"},
    ]

    const attendanceStatusList = [
        { value: "0", label: "Attended" },
        { value: "1", label: "Missed" },
        { value: "2", label: "Rejected" },
    ]

    const submitReport = async (e) => {
        e.preventDefault();

        var flag = false;
        Object.keys(report).forEach(function(key) {
            if (report[key] === "") {
                alert("Fill all input fields.");
                flag = true;
            }
        })

        if (flag) return;

        axios.post(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/report`, report)
            .then(res => {
                console.log(res);
                console.log(res.data);
                navigate("/allUsers"); // navigate to previous page
            })
            .catch(error => {
                console.log(error);
            })
    }

    const onInputChange = (e) => {
        console.log(e)
        console.log("---------------")
        setReport({...report, [e.target.name]: e.target.value});
    }

    const handleChange = (event, name) => {
        setReport({...report, [name]:toInteger(event.value)});
      };

    console.log(report)

    const redirectSurvey = () => {
        console.log("hello")
    }
    // const [selectedOptions, setSelectedOptions] = useState();
    // const [selectedData, setSelectedData] = useState({
    //     "equipment_id?": "equipment_quantity"
    // });

    // function handleSelect(data) {
    //     // console.log("-----")
    //     // console.log(data[data.length-1])
    //     // console.log(e)
    //     setSelectedOptions(data);
    //     data.forEach(fja);

    // }

    // function fja(item) {
    //     setSelectedData({...selectedData, [item.label]:item.value})
    // }

    // console.log(selectedData);

    // console.log(selectedOptions)

    
    // console.log(state?.data);

    return(
        <div className="container position-relative">
            <div className="row">
                <div className="col-md-6 offset-md-4 border rounded p-4 mt-2 shadow position-relative">
                    <h2 className="text-center m-5">Create BD Report</h2>
                    <div className="position-absolute top-0 end-0">
                        <Link 
                            to="/survey/answers"
                            state={ report.user_id }    
                        >
                            <button type="button" onClick={redirectSurvey()} className="float-right btn btn-outline-secondary mt-2 me-2">
                                <RiSurveyLine size={25}/>
                            </button>
                        </Link>
                    </div>
                    <div className="mb-4">
                            <h5 style={{'width':'50%%', 'text-align':'center', 'border-bottom':'1px solid #000', 'line-height':'0.1em', 'margin':'10px 0 20px'}}>
                                <span style={{'background':'#fff', 'padding':'0 5px'}}>Info about <b>{state?.data.user.firstName} {state?.data.user.lastName}</b>'s donation</span></h5>
                    </div>
                    <form onSubmit={(e) => submitReport(e)}>
                        <div className="mb-3">
                            <label htmlFor="attendance" className="form-label">
                                Attendance Status:
                            </label>
                            <div className="dropdown-container">
                                <Select
                                    required
                                    options={attendanceStatusList}
                                    name="attendanceStatus"
                                    placeholder="Choose attendance status"
                                    onChange={(e) => handleChange(e, "attendanceStatus")}
                                    // value={selectedOptions}
                                    // onChange={handleSelect}
                                    isSearchable={true}
                                />
                            </div>
                            {/* <select required className="form-control" name="attendance">
                                <option value="" disabled selected>Choose attendance status</option>
                                <option value="0">Attended</option>
                                <option value="1">Missed</option>
                                <option value="2">Rejected</option>
                            </select> */}
                        </div>
                        {/* <div className="mb-3">
                            <label htmlFor="blood_type" className="form-label">
                                Blood Type:
                            </label>
                            <select required className="form-control" name="blood_type">
                                <option value="" disabled selected>Choose blood type</option>
                                <option value="0">A+</option>
                                <option value="1">A-</option>
                                <option value="2">B+</option>
                                <option value="3">B-</option>
                                <option value="4">0+</option>
                                <option value="5">0-</option>
                                <option value="6">AB+</option>
                                <option value="7">AB-</option>
                            </select>
                        </div> */}
                        <div className="mb-3">
                            <label htmlFor="blood_type" className="form-label">
                                Blood Type:
                            </label>
                            <div className="dropdown-container">
                                <Select
                                    required
                                    options={optionList}
                                    placeholder="Select blood"
                                    name="bloodType"
                                    onChange={(e) => handleChange(e, "bloodType")}
                                    // value={selectedOptions}
                                    // onChange={handleSelect}
                                    isSearchable={true}
                                />
                            </div>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="quantity" className="form-label">
                                Quantity:
                            </label>
                            <div className="input-group">
                                <input
                                    type={"number"}
                                    // step="0"
                                    min="0"
                                    max="500"
                                    className="form-control"
                                    placeholder="Donated blood..."
                                    name="bloodQuantity"
                                    onChange={(e) => onInputChange(e)}
                                    required
                                    />
                                <div className="input-group-append">
                                    <span className="input-group-text" id="basic-addon2">ml</span>
                                </div>
                            </div>
                        </div>
                        <div className="mb-4">
                            <label htmlFor="quantity" className="form-label">
                                Equipment:
                            </label>
                            <div className="input-group">
                                <input
                                    type={"number"}
                                    min="0"
                                    max="15"
                                    className="form-control"
                                    placeholder="Used equipment..."
                                    name="equipmentQuantity"
                                    onChange={(e) => onInputChange(e)}
                                    required
                                    />
                            </div>
                        </div>
                        <div className="md-3">
                            <label id="description">Description:</label> <br/>
                            <textarea 
                                    className="form-control" 
                                    maxLength={255} 
                                    type={"text"} 
                                    name="doctorsNote"
                                    placeholder="Note..." 
                                    onChange={(e) => onInputChange(e)}
                                    required
                            />
                        </div>
                        {/* <div className="mb-4">
                            <h5 style={{'width':'50%%', 'text-align':'center', 'border-bottom':'1px solid #000', 'line-height':'0.1em', 'margin':'10px 0 20px'}}>
                                <span style={{'background':'#fff', 'padding':'0 5px'}}>Equipment</span></h5>
                        </div>
                        <div className="mb-5">
                            <label htmlFor="quantity" className="form-label">
                                Quantity:
                            </label>
                            <div className="input-group">
                                <input
                                    type={"number"}
                                    className="form-control"
                                    placeholder="Used equipment..."
                                    name="equipment_quantity"
                                    required
                                    />
                            </div>
                        </div> */}

                        <button type="submit" className="btn btn-outline-primary" 
                                style={{'width':'150px', 'height':'50px', 'margin-left':'39%', 'margin-top':'15px'}}>
                        Submit
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );

}

export default ReportsCreate;