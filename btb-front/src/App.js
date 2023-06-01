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

import ShowUsers from './Pages/ShowUsers';
import CreateStaff from './Pages/CreateStaff';
import CreateCenter from './Pages/CreateCenter';

import Survey from "./Components/Survey";
import ViewProfile from "./Pages/ViewProfile";
import Centers from "./Pages/Centers";
import DefineAppointment from "./Pages/DefineAppointment";
import MakeApp1 from "./Pages/MakeApp1";
import UserDefineAppointment from "./Pages/UserDefineAppointment";
import CenterCalendar from "./Pages/CenterCalendar";


function App() {
 return (
  <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login/>} />
            <Route path="/home" element={<Home/>} />
            <Route path="/signup" element={<Signup/>} />
            <Route path="/survey" element={<Survey/>} />
            <Route path="/userProfile" element={<ViewProfile/>} />
            <Route path="/centers" element={<Centers/>} />
            <Route path="/defineAppointment" element={<DefineAppointment/>} />
            <Route path="/userDefineAppointment" element={<UserDefineAppointment/>} />
          </Routes>
        </BrowserRouter>
      </div>
 );
}

export default App;
