import {React, useEffect, useState} from 'react'
import axios from 'axios'

function ComplaintUser() {
    const user = JSON.parse(localStorage.getItem('user'));
    const id = user["id"];
    const [complaint, setComplaint] = useState([])

    useEffect(() => {
        axios.get(`http://localhost:8084/api/complaint/user/withAnswer/${id}`,
        {
          headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
          }
        })
        .then(res => {
          console.log(res.data)
          setComplaint(res.data)
        })
        .catch(error => {
          console.log(error)
        })
      }, [])

  return (
    <div style={{marginLeft:'280px'}}>
         <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Complaint</th>
      <th scope="col">Answer</th>
      <th scope="col">From admin</th>
    </tr>
  </thead>
  <tbody>
   {complaint.map(c => (
    <tr>
      <th>{c.context}</th>
      <th>{c.answer}</th>
      <th>{c.admin.firstName} {c.admin.lastName}</th>
      
    </tr>
   ))}
  </tbody>
</table>
    </div>
  )
}

export default ComplaintUser