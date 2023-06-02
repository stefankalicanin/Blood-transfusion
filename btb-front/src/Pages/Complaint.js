import {React, useEffect, useState} from 'react'
import axios from 'axios'
import Button from 'react-bootstrap/Button'
import Modal from 'react-bootstrap/Modal';
import Form from 'react-bootstrap/Form';

function Complaint() {

  const user = JSON.parse(localStorage.getItem('user'));
  const id = user["id"];
  const [complaintWithoutAnswer, setComplaintWithoutAnswer] = useState([]);
  const [complaintWithAnswer, setComplaintWithAnswer] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [complaintDetailsByUser, setComplaintDetailsByUser] = useState({
    context : ''
  });
  const [answer, setAnswer] = useState({
    answer : ''
  });

  useEffect(() => {
    axios.get(`http://localhost:8084/api/complaint/admin/withoutAnswer/${id}`)
    .then(res => {
      console.log(res.data)
      setComplaintWithoutAnswer(res.data)
    })
    .catch(error => {
      console.log(error)
    })
  }, [])

  useEffect(() => {
    axios.get(`http://localhost:8084/api/complaint/admin/withAnswer/${id}`)
    .then(res => {
      console.log(res.data)
      setComplaintWithAnswer(res.data)
    })
    .catch(error => {
      console.log(error)
    })
  }, [])

  const complaintDetails = (complaint) => {
    setShowModal(!showModal);
    setComplaintDetailsByUser(complaint);
  }

  const confirmComplaint = (id) => {
    axios.post(`http://localhost:8084/api/complaint/update/${id}/${answer.answer}`,
      {
        headers: {
            'Authorization': 'Bearer ' + localStorage.getItem('token')
          }
    })
    .then(res => {
      window.location.assign('/admin/complaint');
    })
  }

  const handleFormInputChange = (name) => (event) => {
    const val = event.target.value;
    setAnswer({...answer, [name] : val});
    
  };

  return (
    <div style={{marginLeft:'260px'}}>
      <div class="row">
        <div class="col">
        <table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Complaint</th>
      <th scope="col">Write report</th>
    </tr>
  </thead>
  <tbody>
   {complaintWithoutAnswer.map(cwa => (
    <tr>
      <th>Complaint from : {cwa.user.firstName} {cwa.user.lastName}</th>
      <th><Button variant="success" onClick={()=>complaintDetails(cwa)}>Write report</Button></th>
    </tr>
   ))}
  </tbody>
</table>
</div>
<div class="col">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Complaint</th>
      <th scope="col">Answer</th>
      <th scope="col">From user</th>
    </tr>
  </thead>
  <tbody>
   {complaintWithAnswer.map(cwa => (
    <tr>
      <th>{cwa.context}</th>
      <th>{cwa.answer}</th>
      <th>{cwa.user.firstName} {cwa.user.lastName}</th>
    </tr>
   ))}
  </tbody>
</table>
</div>
</div>
<Modal show={showModal}>
        <Modal.Header closeButton onClick={()=> setShowModal(!showModal)}>
          <Modal.Title>Complaint details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
         <p>{complaintDetailsByUser.context}</p>
         <Form>
                <Form.Group className="mb-3" controlId="formBasicAnswer">
                    <Form.Label>Answer</Form.Label>
                    <Form.Control type="text" placeholder="Enter answer" name="answer" value={answer.answer} onChange={handleFormInputChange("answer")}/>
                </Form.Group>
        </Form>
         <Button onClick={()=>confirmComplaint(complaintDetailsByUser.id)}>Confirm</Button>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="danger" onClick={()=> setShowModal(!showModal)}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  )
}

export default Complaint