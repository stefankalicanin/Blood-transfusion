import React from 'react';
import { useSearchParams } from 'react-router-dom';

function Reports() {

    const [searchParams] = useSearchParams();
    const userId = searchParams.get("userId")

    // const searchParams = new URLSearchParams(search);

    console.log(userId);
    
   
    return (
        <div className="reports">
            <h1>Reports</h1>
        </div>
    );
}

export default Reports;