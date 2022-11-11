import React, { Component } from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  Link,
  Outlet
} from "react-router-dom";
import Home from "./Components/Home";
import Login from "./Components/Login";
import Signup from "./Components/Signup";

import "../node_modules/bootstrap/dist/css/bootstrap.min.css";

function App() {
 return (
  <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login/>} />
            <Route path="/home" element={<Home/>} />
            <Route path="/signup" element={<Signup/>} />
          </Routes>
        </BrowserRouter>
      </div>
 );
}

export default App;
