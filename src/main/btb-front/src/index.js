import React from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  Outlet,
} from "react-router-dom";
import StaffUpdate from "./Routes/StaffUpdate";
import Reports from "./Routes/Reports";
import Navbar from "./Components/Navbar";
import "./App.css"
import EditCenter from "./Routes/EditCenter";
import EditCenterInfo from "./Pages/EditCenterInfo";


const AppLayout = () => (
    <>
        <Navbar />
        <Outlet />
    </>
)

// const router = createBrowserRouter(createRoutesFromElements(
//     <Route element={<AppLayout />}>
//         <Route path="/" element={<Home/>} />
//         <Route path="/staff/editCenter" element={<Products/>} />
//         <Route path="/reports" element={<Reports/>} />
//     </Route>
// ))

const router = createBrowserRouter([
    {
        element: <AppLayout />,
        children: [
            {
                path: "/"
            },
            {
                path: "staff/updateProfile",
                element: <StaffUpdate />
            },
            {
                path: "staff/editCenter",
                element: <EditCenter/>,
            },
            {
                path: "reports",
                element: <Reports/>,
            }
        ]
    }
]);

createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);
