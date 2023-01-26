import React, { Component, useState, useEffect, useMemo } from "react";
import axios from "axios";
import { Link } from 'react-router-dom';

export default function MakeApp1() {
    const [centers, setCenters] = useState([]);
    const [first, setFirst] = useState(true);

    const [searchFilter, setSearchFilter] = useState({
        date : "",
        time : ""
    });

    const [isSorted,setIsSorted] = useState({
        grade:false
      });

    useEffect(() => {
        if (first){
            loadCenters();
            setFirst(!first);
        }
    }, []);

    const loadCenters = async () => {
        const result = await axios.get('http://localhost:8084/api/center');
        setCenters(result.data);
    };

    const onInputChange = (e) => {
        setSearchFilter({ ...searchFilter, [e.target.name]: e.target.value });
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        const result = await axios.get(`http://localhost:8084/api/center/getAllByDateTime?date=` + searchFilter.date + '&time=' + searchFilter.time);
        setCenters(result.data);
    };

    const sortByVal = (e) => {
        const centerCopy = [...centers];
        const val = e.target.id;
        console.log("============");
          // console.log(centerCopy[0][val]);
        if (isSorted[val] === false) {
          
          const sortedCenter = centerCopy.sort((a, b) => (a[val] < b[val] ? -1 : 1));
          setIsSorted(true);
          setIsSorted({...isSorted, [val]:true})
          
          // console.log(isSorted);
          setCenters(sortedCenter);
        } else if (isSorted[val] === true) {
          const sortedCenter = centerCopy.sort((a, b) => (a[val] > b[val] ? -1 : 1));
          // setIsSorted(false);
          setIsSorted({...isSorted, [val]:false})
          // console.log(isSorted);
          setCenters(sortedCenter);
        }
      }
  

  
    return (
    <div style={{'margin-left':'280px'}}>
        <div className='py-4'>
            <form onSubmit={(e) => onSubmit(e)}>
                <input type="date" placeholder="Date" name="date" onChange={(e) => onInputChange(e)}></input>
                <input type="time" placeholder="Time "name="time" onChange={(e) => onInputChange(e)}></input>
                <input type="submit" value="Search"></input>
            </form>
            <form>
            <table className="table border rounded p-4 mt-2 shadow table-striped" >
                <thead>
                    <tr className='table-dark'>
                        <th scope="col"></th>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th scope="col" id="grade" style={{'cursor':'pointer'}} onClick={(e) => sortByVal(e)} >Grade ^v</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        centers.map((center,index)=>(
                            <tr className='table-light'>
                                <td scope="row">{index+1}</td>
                                <td>{center.name}</td>
                                <td>{center.address}</td>
                                <td>{center.grade}</td>
                                <td><input 
                         className='form-check-input'
                         type="checkbox"
                         /></td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
                <Link className="add-btn" to="/userDefineAppointment"><button className=""update-btn mx-2>Add</button></Link>
            </form>
        </div>
    </div>
  )
}
