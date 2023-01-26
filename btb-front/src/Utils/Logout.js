import { useEffect } from "react";
import { useNavigate } from "react-router";

function Logout() {
    console.log(localStorage.getItem('token'))
    localStorage.clear();
    // window.location.href = '/';

    const navigate = useNavigate();
    useEffect(() => {
        console.log("hello")
        localStorage.clear();
        window.location.href = '/';
        navigate("/login")
        navigate(0)
    },[])

    return(
        <div></div>
    )
    
}

export default Logout;