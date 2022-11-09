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


class App extends Component {
  render() {
    return (
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/signup" element={<Signup/>} />
            <Route path="/login" element={<Login/>} />
          </Routes>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;
