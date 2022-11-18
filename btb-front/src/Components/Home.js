import React, { Component, useState, useEffect, useMemo } from "react";
import { Link } from "react-router-dom";
import { Container } from "react-bootstrap";
import HCSS from './Home.module.css';
import { Countries } from "./Countries"
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';
import axios from "axios";

export default function Home(){
  const [countries,setCountries] = useState(
    [{
      id:"",
      name: "",
      address: "",
      description: "",
      grade: ""
    }]
  );
  const [isSorted,setIsSorted] = useState({
    name:false,
    address:false,
    grade:false,
    description:false
  });
  
  useEffect(() => {
    //console.log(countries[1].phone);
    fetchCenters()
  }, []);


  const fetchCenters = async () => {
    try {
      const loadedCountries = await axios.get(`http://localhost:8084/api/center`);
      console.log("--------------------")
      console.log(loadedCountries.data);

      setCountries(loadedCountries.data);
    } catch (error) {
      console.log(error.response.data);
    }
  }

  // const sortByName =()=>{
  //   if (isSorted == false){
  //     countries.sort((a, b) => (a.name < b.name ? -1 : 1));
  //     setCountries(countries);
  //     setIsSorted(true);
  //   }
  //   else { 
  //     setCountries(Countries());
  //     setIsSorted(false);
  //   } 
  // }

  
  const sortByName = () => {
    const centerCopy = [...countries];
    if (isSorted === false) {
      const sortedCenter = centerCopy.sort((a, b) => (a.name < b.name ? -1 : 1));
      setIsSorted(true);
      setCountries(sortedCenter);
    } else {
      const sortedCenter = centerCopy.sort((a, b) => (a.name > b.name ? -1 : 1));
      setIsSorted(false);
      setCountries(sortedCenter);
    }
  }


  const sortByVal = (e) => {
    const centerCopy = [...countries];
    const val = e.target.id;
    console.log("============");
      // console.log(centerCopy[0][val]);
    if (isSorted[val] === false) {
      
      const sortedCenter = centerCopy.sort((a, b) => (a[val] < b[val] ? -1 : 1));
      setIsSorted(true);
      setIsSorted({...isSorted, [val]:true})
      
      // console.log(isSorted);
      setCountries(sortedCenter);
    } else if (isSorted[val] === true) {
      const sortedCenter = centerCopy.sort((a, b) => (a[val] > b[val] ? -1 : 1));
      // setIsSorted(false);
      setIsSorted({...isSorted, [val]:false})
      // console.log(isSorted);
      setCountries(sortedCenter);
    }
  }

  
  const sortByDegree =()=>{
    if (isSorted == false){
      countries.sort((a, b) => (a.phone < b.phone ? -1 : 1));
      setCountries(countries);
      setIsSorted(true);
    }
    else { 
      setCountries(Countries());
      setIsSorted(false);
    } 
  }
    return (
      <div style={{'margin-left':'280px'}}>
         <h1 className={HCSS.h1}>Home</h1>
        <p>
          <Link to="/survey">Popunjavanje upitnika davaoca krvi</Link>
        </p>
{/*
        <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
      <Dropdown.Item href="#/action-3">Something else</Dropdown.Item> */}
      {/* <DropdownButton id="dropdown-basic-button" title="Dropdown button">
           {countries.map(element => {
            return (
            <Dropdown.Item href={"#/"+element.code+element.label+element.phone} >{element.code +" " + element.label +" "+ element.phone}</Dropdown.Item>
            );
          })}
        </DropdownButton> */}
        <div className='py-4'>
        <table className="table border rounded p-4 mt-2 shadow table-striped" >
  <thead>
    <tr className='table-dark'>
      <th>#</th>
      <th scope="col" id="name" style={{'cursor':'pointer'}} onClick={(e) => sortByVal(e)} key="1">Name</th>
      <th scope="col" id="address" style={{'cursor':'pointer'}} name="address" onClick={(e) => sortByVal(e)}>Address</th>
      <th scope="col" id="grade" style={{'cursor':'pointer'}} onClick={(e) => sortByVal(e)} >Grade</th>
      <th scope="col" id="description" style={{'cursor':'pointer'}} onClick={(e) => sortByVal(e)}>Description</th>
    </tr>
  </thead>
 <tbody>
    {
        countries.map((countrie,index)=>(
        <tr className='table-light'>
        <th scope="row" key={index}>{index+1}</th>
        <td key="label">{countrie.name}</td>
        <td>{countrie.address}</td>
        <td>{countrie.grade}</td>
        <td>{countrie.description}</td>
        </tr>
        ))
    }
  </tbody>
</table>
        </div>
      </div>
    )
}