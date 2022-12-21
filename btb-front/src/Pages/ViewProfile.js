import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function ViewProfile() {
  const [user, setUser] = useState({
    id : "",
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    jmbg: "",
    phone: "",
    gender: "",
    address: "",
    city: "",
    country: "",
    profession: "",
    job: ""
  });

  const [first, setFirst] = useState(true);
  const [disabled, setDisabled] = useState(true);

  const navigate = useNavigate();
  
  useEffect(() => {
    if (!localStorage.getItem('token') || !localStorage.getItem('user')){
      navigate("/login")
    }
    const user = JSON.parse(localStorage.getItem('user'))
    if (user['role'] != "USER") {
      navigate("/")
    }


    if (first){
      loadUser();
      setFirst(!first);
    }
  });

  const loadUser = async () => {
    const user = JSON.parse(localStorage.getItem('user'));

    const result = await axios.get('http://localhost:8084/api/user/ ' + user.id, {
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem('token')
      }});
    setUser(result.data);
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.put(`http://localhost:8084/api/user/update`, user, {
      headers: {
        'Authorization': 'Bearer ' + localStorage.getItem('token')
      }});
    setDisabled(true);
  };

  function enableFields(){
    setDisabled(false)
  }

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">User Details</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                First Name
              </label>
              <input
                type="text"
                className="form-control"
                placeholder="Enter your name"
                name="firstName"
                value={user.firstName}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Lastname" className="form-label">
                Last Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your lastname"
                name="lastName"
                defaultValue={user.lastName}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">
                Email
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your email"
                name="email"
                defaultValue={user.email}
                disabled={true}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Jmbg" className="form-label">
                Jmbg
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your JMBG"
                name="jmbg"
                defaultValue={user.jmbg}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Phone" className="form-label">
                Phone
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your phone"
                name="phone"
                defaultValue={user.phone}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Gender" className="form-label">
                Gender
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your gender"
                name="gender"
                defaultValue={user.gender}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Address" className="form-label">
                Address
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your address"
                name="address"
                defaultValue={user.address}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="City" className="form-label">
                City
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your city"
                name="city"
                defaultValue={user.city}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Contry" className="form-label">
                Contry
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your country"
                name="country"
                defaultValue={user.country}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Job" className="form-label">
                Job
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your job"
                name="job"
                defaultValue={user.job}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Profession" className="form-label">
                Profession
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your profession"
                name="profession"
                defaultValue={user.profession}
                disabled={disabled}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <input type="button" className="btn btn-outline-primary" value="Edit" onClick={enableFields}/>
            <input type="submit" className="btn btn-outline-primary" value="Submit"/>
          </form>
        </div>
      </div>
    </div>
  );
}