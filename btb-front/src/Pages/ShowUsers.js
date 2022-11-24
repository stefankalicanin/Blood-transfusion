import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom'

export default function ShowUsers() {

    const [users,setUsers]=useState([])
    const [filterData,setFilterData]=useState([])
    const[query,setQuery]=useState('')
    

    useEffect(()=>{
        loadUsers(); 
    },[])

    const loadUsers=async()=>{
        const result=await axios.get("http://localhost:8084/api/user")
        setUsers(result.data);
        setFilterData(result.data);
    }

    const handleSearch=(event)=>
  {
    const getSearch=event.target.value;
    setQuery(getSearch);
   
    if(getSearch.length>0)
    {
      const searchData=users.filter((item)=>item.firstName.toLowerCase().includes(getSearch.toLowerCase().trim()) || item.lastName.toLowerCase().includes(getSearch.toLowerCase().trim()));
      setUsers(searchData);
    }
    else
    {
      setUsers(filterData);
    }
    setQuery(getSearch);
  }


  const navigate = useNavigate();

  const handleRowClick = async (data) => {
    // navigate({
    //   pathname: "/",
    //   search: `?userId=${userId}`,
    //   state: { data: userId },
    // })
    navigate('/reports',
    {
      state: {
        data
      }
    })
    // <Link to="/"/>
  }
  
  return (
    <div className='container'>
        <div className='py-4' style={{'width':'75%','margin-left':'280px'}}>
        <input type="text" name="name" value={query} className="form-control" onChange={(e)=>handleSearch(e)} placeholder="search..."/><br/>
        <table className="table table-hover border rounded p-4 mt-2 shadow table-striped" style={{'cursor': 'pointer'}}>
  <thead>
    <tr className='table-dark'>
      <th scope="col"></th>
      <th scope="col">JMBG</th>
      <th scope="col">FIRSTNAME</th>
      <th scope="col">LASTNAME</th>
      <th scope="col">EMAIL</th>
    </tr>
  </thead>
  <tbody>
    {
        users.map((user,index)=>(
        <tr className='table-light' onClick={() => handleRowClick(user)}>
        <th scope="row" key={index}>{index+1}</th>
        <td>{user.jmbg}</td>
        <td>{user.firstName}</td>
        <td>{user.lastName}</td>
        <td>{user.email}</td>
        </tr>
        ))
    }
  </tbody>
</table>
<p style={{'margin-left':'745px', 'margin-top':'20px'}}>Click on row to select the user</p>
        </div>
    </div>
  )
}

/*
Link to={{
          pathname: "/reports",
          search: `?userId=${user.id}`,
        }}
*/

/*
          <Link
            to="/reports"
            state={{data: user.id}}>

*/