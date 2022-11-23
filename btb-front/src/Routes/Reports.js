import axios from 'axios';
import React, { useState } from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

var CONFIG = require("../Config/server.json");

function Reports() {

    const { state } = useLocation()
    
    const [appointments, setAppointments] = useState({});
    // const data = location.state?.data;

    // console.log(data);
    // console.log(location.state)
    
    // const [searchParams] = useSearchParams();
    // const userId = searchParams.get("userId")

    console.log(state?.data)

    const fetchData = async() => {
        try {
            const user_id = state?.data.id;
            const loadedScheduledAppointments = await axios.get(`http://${CONFIG.IP_ADDRESS}:${CONFIG.PORT}/api/scheduled/${user_id}`);
        } catch (error) {
            console.log(error.response.data);
        }
    }

    // const searchParams = new URLSearchParams(search);

    // console.log(userId);
    
   
    return (
        <div className="reports">
            <h1>Reports</h1>
        </div>
    );
}

export default Reports;