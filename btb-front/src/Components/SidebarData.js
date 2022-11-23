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
        role: ["staff"]
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
        title: "Edit Center",
        path: "/staff/editCenter",
        cName: "nav-text",
        role: ["staff"]
    },
    {
        title: "Create Staff",
        path: "/admin/createStaff",
        cName: "nav-text",
        role: ["admin"]
    },
    {
        title: "Create Center",
        path: "/admin/createCenter",
        cName: "nav-text",
        role: ["admin"]
    },
    {
        title: "Show Users",
        path: "/allUsers",
        cName: "nav-text",
        role: ["admin", "staff"]
    },
    {
        title: "Centers",
        path: "/centers",
        cName: "nav-text",
        role: ["admin", "user", ""]
    },
    {
        title: "Profile",
        path: "/viewProfile",
        cName: "nav-text",
        role: ["user"]
    },
    {
        title: "Register Admin",
        path: "/admin/createAdmin",
        cName: "nav-text",
        role: ["admin"]
    },
    {
        title: "Change Admin Password",
        path: "/admin/changePassword",
        cName: "nav-text",
        role: ["admin"]
    }
];