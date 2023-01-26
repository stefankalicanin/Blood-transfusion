import React, {useState, useEffect}  from 'react' 
import axios from 'axios';


function BookAppointment(){
    /*
    const fetchUser = async () => {
        const options = {
        method: 'GET',
        url: 'http://localhost:8084/api/appointment/getAllAvailable',
        headers: {
            'Authorization: ': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6InVzZXJAZ21haWwuY29tIiwiYXVkIjoid2ViIiwiaWF0IjoxNjc0NzUzNzQ0LCJleHAiOjE2NzQ3NTU1NDR9.QVx_xOw90VvVsN4As4wR7fwHycVw3quSQ0UZ9FSLi6b1PhupFKx7x6-Q7r3M0Eee9GzAeuUl_o6Dl5cVfIr5Tg'
        }
        };

        axios.request(options).then(function (response) {
        console.log(response.data);
        }).catch(function (error) {
        console.error(error);
        });
    }
    useEffect(() => {
        (async () => {
          setUserLoaded(false);
          let res = await fetchUser();
          if (res.success) {
            setUserLoaded(true);
            setAnswers(res.data);  
          }
        })();
      }, []);
*/
    
      return (
        <div style={{'margin-left':'280px'}}>
            JOOOO
    </div>
      )
}
export default BookAppointment;