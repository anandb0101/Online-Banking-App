import React from 'react';

import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, useNavigate } from 'react-router-dom';

const DashboardNavbar = () => {

  const usenaviagte = useNavigate();

  const handleLogout = (e) => {
    sessionStorage.clear();
    usenaviagte('/home');
  }

  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Wells Fargo</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            
            <NavDropdown title="Fund Transfer" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">To Beneficiary</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.2">
                <Link className='btn' to ={"/payment"} >Quick Transfer</Link>
              </NavDropdown.Item>
            </NavDropdown>

            <Link className='btn' to={"/changepassword"}>Change Password</Link>
            <Link className='btn' to={"/contact"}>Contact Us</Link>

            <Link className='btn' to={"/login"} onClick={handleLogout}>Logout</Link>

          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default DashboardNavbar;
