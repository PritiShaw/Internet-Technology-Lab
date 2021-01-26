import React from 'react';
import { Navbar, Button, Dropdown } from 'react-bootstrap';

const ModuleOne =() =>{
    return(
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home" style={{fontSize:"xxx-large", fontWeight: "bolder"}}>NearBy Stores</Navbar.Brand>
            <div style={{paddingLeft: "350px"}}>
                <Dropdown >
                    <Dropdown.Toggle variant="success" id="dropdown-basic">Choose a Category for nearby Store</Dropdown.Toggle>
                    <Dropdown.Menu>
                        <Dropdown.Item href="#/action-1">Medical Store</Dropdown.Item>
                        <Dropdown.Item href="#/action-2">Grocery Store</Dropdown.Item>
                        <Dropdown.Item href="#/action-3">Electricity Store</Dropdown.Item>
                    </Dropdown.Menu>
                    <Button style={{marginLeft: "0.5em", width:"100px"}} variant="outline-info">Search</Button>
                </Dropdown>
            </div>
        </Navbar>
    );
};

export default ModuleOne;