import React, { Component } from "react";
import { Link } from "react-router-dom";
import { Container } from "react-bootstrap";
import HCSS from './Home.module.css';

export default function Home(){
    return (
      <Container>
        <h1 className={HCSS.h1}>Home</h1>
        <p>
          <Link to="/survey">Popunjavanje upitnika davaoca krvi</Link>
        </p>
        <p>
          <Link to="/dashboard">Dashboard</Link>
        </p>
      </Container>
    )
}