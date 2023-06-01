import {React, useState, useEffect} from 'react'
import axios from 'axios'
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import Modal from 'react-bootstrap/Modal'
import Button from 'react-bootstrap/Button'
const localizer = momentLocalizer(moment);

function CenterCalendar() {

    const user = JSON.parse(localStorage.getItem('user'))
    const id = user["center_id"]
    const [appointment, setAppointment] = useState([])
    const [users, setUsers] = useState({})
    const [showModal, setShowModal] = useState(false)
    const [error, setError] = useState(false)
    useEffect(() => {
        axios.get(`http://localhost:8084/api/appointment/byCenter/${id}`, 
        {
            headers: {
                'Authorization': 'Bearer ' + localStorage.getItem('token')
              }
        })
        .then(res => {
          setAppointment(res.data)
            console.log(res.data)
        })
        .then(error => {
            console.log(error)
        })
    }, [])

    const transformDataForCalendar = (data) => {
      return data.map((item) => {
        const eventDate = moment(item.date, 'YYYY-MM-DD');
        const eventTime = moment(item.time, 'HH:mm');
    
        const start = eventDate.clone().set({
          hour: eventTime.hour(),
          minute: eventTime.minute(),
          second: 0,
        });
    
        const end = start.clone().add(item.duration, 'hour'); 
    
        return {
          start: start.toDate(),
          end: end.toDate(),
          title: "Termin", 
          id : item.id,
        };
      });
    };

    const events = transformDataForCalendar(appointment);
    const handleSelectEvent = (event) => {
      axios.get(`http://localhost:8084/api/schedule/user/${event.id}`, 
      {
          headers: {
              'Authorization': 'Bearer ' + localStorage.getItem('token')
            }
      })
      .then(res => {
          console.log(res.data)
          setUsers(res.data)
          setShowModal(!showModal)
          setError(false)
      })
      .catch(error => {
        setUsers("")
        setError(true)
        setShowModal(!showModal)
      })

    };

  return (
    <div style={{marginLeft:'280px'}}>
      <h1>My Calendar</h1>
      <Calendar
        localizer={localizer}
        events={events}
        startAccessor="start"
        endAccessor="end"
        style={{ height: '500px' }}
        onSelectEvent={handleSelectEvent}
      />
      <Modal show={showModal}>
        <Modal.Header closeButton onClick={()=> setShowModal(!showModal)}>
          <Modal.Title>User details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          {
            !error ?
            <div>
        <h1>First Name:{users.firstName}</h1>
        <h1>Last Name:{users.lastName}</h1>
        </div>:
        <div>
          <h1>Term is free</h1>
        </div>
          }
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

export default CenterCalendar