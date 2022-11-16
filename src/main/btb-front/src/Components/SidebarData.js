import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";

export const SidebarData = [
    {
        title: "Home",
        path: "/home",
        icons: <AiIcons.AiFillHome />,
        cName: "nav-text",
        role: ["user", "admin", "staff"]
    },
    {
        title: "Profile",
        path: "staff/updateProfile",
        icons: <IoIcons.IoIosPaper />,
        cName: "nav-text",
        role: ["admin", "staff"]
        // role: [
        //     "admin", "staff"
        // ]
    },
    {
        title: "Login",
        path: "/login",
        cName: "nav-text",
        role: [""]
    },
    {
        title: "Signup",
        path: "/signup",
        cName: "nav-text",
        role: [""]
    },
    {
        title: "Survey",
        path: "/survey",
        cName: "nav-text",
        role: ["user"]
    },
    {
        title: "Center",
        path: "/staff/editCenter",
        cName: "nav-text",
        role: ["staff"]
    }
];