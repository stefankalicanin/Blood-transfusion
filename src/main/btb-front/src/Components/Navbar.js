import React, {useEffect, useState} from "react";
import * as FaIcons from "react-icons/fa";
// import * as AiIcons from "react-icons/ai";
import { Link } from "react-router-dom";
import { SidebarData } from "./SidebarData";
import "../App.css";
import { IconContext } from "react-icons";

function Navbar() {

    const [sidebar, setSidebar] = useState(false);
    const [role, setRole] = useState("user");

    useEffect(() => {
    //   setRole(localStorage.getItem('role'));
    }, [])
    

    const showSidebar = () => setSidebar(!sidebar);

    return (
        <>
        <IconContext.Provider value={{ color: "undefined" }}>
            <div className="navbar">
                <Link to="#" className="menu-bars">
                    <FaIcons.FaBars onClick={showSidebar}/>
                </Link>
            </div>
            {/* <nav className={sidebar ? "nav-menu active": "nav-menu active"}> */}
            <nav className="nav-menu active">
                <ul className="nav-menu-items" onClick={showSidebar}>
                    <li className="navbar-toggle">
                        <Link to="#" className="menu-bars">
                            <FaIcons.FaUser/> <label className="test">User</label>
                        </Link>
                    </li>
                    {SidebarData.map((item, index) => {
                        if (item.role.includes(role)) {
                            return (
                                <li key={index} className={item.cName}>
                                <Link to={item.path}>
                                    {item.icons}
                                    <span>{item.title}</span>
                                </Link>
                            </li>
                        );
                    }
                    })}
                </ul>
            </nav>
        </IconContext.Provider>
        </>
    );
}

export default Navbar;