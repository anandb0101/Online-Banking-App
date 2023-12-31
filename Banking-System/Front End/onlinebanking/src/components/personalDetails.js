import './personalDetails.css'; // Import the CSS file for styling
import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import {Link, useNavigate } from 'react-router-dom';

function PersonalDetails() {

  const [details, setDetails] = useState('');

  useEffect(() => {
    let token = sessionStorage.getItem('JwtToken');
    let username = sessionStorage.getItem('username');

    fetch(" http://localhost:8080/personalDetails/" + username, {
      method: "GET",
      headers: { "Authorization" : `Bearer ${token}`,
      "Content-Type": "application/json" }
    }).then((res) => {
        return res.json();
    }).then ((resp) => {
        setDetails(resp);
    }).catch((err) => {
      console.log("Error: " + err.message);
    })

  }, []);

  return (
    <div className="personal-details-container">
      <h2>Personal Details</h2>
      <div className="details">
        <div className="detail-item">
          <label>Name:</label>
          <span>{details.name}</span>
        </div>
        <div className="detail-item">

          <label>username:</label>
          <span>{details.username}</span>

        </div>
        <div className="detail-item">
          <label>Father's Name:</label>
          <span>{details.fatherName}</span>
        </div>
        <div className="detail-item">
          <label>Address:</label>
          <span>{details.address}</span>
        </div>
        <div className="detail-item">
          <label>Email ID:</label>
          <span>{details.email}</span>
        </div>
        <div className="detail-item">
          <label>Phone Number:</label>
          <span>{details.mobile}</span>
        </div>
        <div className="detail-item">
          <label>Aadhar Number:</label>
          <span>{details.aadhaarNumber}</span>
        </div>
        <div className="detail-item">
          <label>PAN Number:</label>
          <span>{details.pan}</span>
        </div>
        <div className="detail-item">
          <label>Gender:</label>
          <span>{details.gender}</span>
        </div>
        <div className="detail-item">
          <label>Country:</label>
          <span>{details.country}</span>
        </div>
      </div>

      <div style = {{padding: "10px"}}>
        <Button variant="primary" >
        <Link to="/dashboard" className="btn btn-default">Back To Dashboard</Link>
        </Button>
      </div>
      
    </div>
  );
}

export default PersonalDetails;
