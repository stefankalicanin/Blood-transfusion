import React, {useEffect, useState} from "react";
import * as FaIcons from "react-icons/fa";
// import * as AiIcons from "react-icons/ai";
import { Link } from "react-router-dom";
import { SidebarData } from "./SidebarData";
import "../App.css";
import { IconContext } from "react-icons";


function Navbar() {

    const [sidebar, setSidebar] = useState(false);
    const [role, setRole] = useState("");
    const [status, setStatus] = useState(true)
    useEffect(() => {
        const user = localStorage.getItem('user');
        if (user === null) {
            setRole("");
        } else {
            const ta = JSON.parse(user)
            console.log(ta.role)
            console.log(ta["role"])
            // console.log(user.)
            setRole(ta["role"]);
            setStatus(ta["status"])
            console.log(ta["status"])
           
        }
    }, [localStorage.getItem('user')])
    

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
                 
                    { status && SidebarData.map((item, index) => {
                        if (item.role.includes(role.toLowerCase())) {
                            
                            return (
                                <li key={index} className={item.cName}>
                                <Link to={item.path}>
                                    {item.icons}
                                    <span>{item.title}</span>
                                </Link>
                            </li>
                        );
                        
                   }
                        

                    }
                    
                    )}
                   
                   {!status &&  <div><li  className="nav-text">
                                <Link to="/admin/changePassword">
                                    
                                    <span>Change password</span>
                                </Link>
                            </li>
                            <li  className="nav-text">
                                <Link to="/logout">
                                    
                                    <span>Logout</span>
                                </Link>
                            </li>
                            </div>}
                               
                    
                </ul>
            </nav>
        </IconContext.Provider>
        </>
    );
}

export default Navbar;