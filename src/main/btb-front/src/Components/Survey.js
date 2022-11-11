import React, { Component } from "react";
import axios from "axios";
import _ from "lodash";

export default function Survey(){
    const response_data = null;
    const options = {method: 'GET', url: 'http://localhost:8084/api/questions'};
    axios.request(options).then(function (response) {
    console.log(response.data);
    response_data = response.data;
    }).catch(function (error) {
    console.error(error);
    });

    
    return (
        <div className="container">
        <ol>
          {_.times(3, (i) => (
            <li key={i}>repeated 3 times</li>
          ))}
        </ol>
      </div>
    )
}