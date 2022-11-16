import React, { Component, useState, useEffect, useMemo } from "react";
import { Link } from "react-router-dom";
import { Container } from "react-bootstrap";
import HCSS from './Home.module.css';
import { Countries } from "./Countries"
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

export default function Home(){
  const [countries,setCountries] = useState([]);
  const [isSorted,setIsSorted] = useState(false);
  const loadCountries = useMemo(()=>{
    console.log("Use memo countries");
    return Countries()

  }, [])
  useEffect(() => {
    //console.log(countries[1].phone);
    setCountries(Countries());
    console.log("Use effect countries")
  }, []);


  const sortByName =()=>{
    if (isSorted == false){
      countries.sort((a, b) => (a.label < b.label ? -1 : 1));
      setCountries(countries);
      setIsSorted(true);
    }
    else { 
      setCountries(Countries());
      setIsSorted(false);
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
      <div>
        {/* <h1 className={HCSS.h1}>Home</h1>
        <p>
          <Link to="/survey">Popunjavanje upitnika davaoca krvi</Link>
        </p>
        <p>
          <Link to="/dashboard">Dashboard</Link>
        </p>

        <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
      <Dropdown.Item href="#/action-3">Something else</Dropdown.Item> */}
      <DropdownButton id="dropdown-basic-button" title="Dropdown button">
           {countries.map(element => {
            return (
            <Dropdown.Item href={"#/"+element.code+element.label+element.phone} >{element.code +" " + element.label +" "+ element.phone}</Dropdown.Item>
            );
          })}
        </DropdownButton>
        <div className='py-4'>
        <table className="table border rounded p-4 mt-2 shadow table-striped" >
  <thead>
    <tr className='table-dark'>
      <th scope="col"></th>
      <th scope="col" key="1">Naziv</th>
      <th scope="col" key="label" onClick={sortByName}>Grad</th>
      <th scope="col" onClick={sortByDegree} >Ocena</th>
    </tr>
  </thead>
  {isSorted ? (
  <tbody>
    {
        countries.map((countrie,index)=>(
        <tr className='table-light'>
        <th scope="row" key={index}>{index+1}</th>
        <td key="label">{countrie.code}</td>
        <td>{countrie.label}</td>
        <td>{countrie.phone}</td>
        </tr>
        ))
    }
  </tbody>
  ) : (
    // <p>No question found, please try again</p>
    <tbody>
    {
        countries.map((countrie,index)=>(
        <tr className='table-light'>
        <th scope="row" key={index}>{index+1}</th>
        <td key="label">{countrie.code}</td>
        <td>{countrie.label}</td>
        <td>{countrie.phone}</td>
        </tr>
        ))
    }
  </tbody>
  )}
</table>
        </div>
      </div>
    )
}