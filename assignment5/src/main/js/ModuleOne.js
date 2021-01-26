import React from 'react';
import { Navbar, Button, Dropdown } from 'react-bootstrap';

const ModuleOne = ({category, setCategory}) =>{    
    return(
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home" style={{fontSize:"xxx-large", fontWeight: "bolder"}}>NearBy Stores</Navbar.Brand>            
            <div className="ml-auto">
                <div className=" input-group">
                    <select className="form-control d-inline" value={category} onChange={(e)=>setCategory(e.target.value)}>
                        <option hidden>Choose Category</option>
                        <option value={1}>Medical</option>
                        <option value={2}>Grocery</option>
                        <option value={3}>Hospital</option>
                    </select>
                    {/* <div className="input-group-append">
                        <span className="input-group-text btn btn-primary">Search</span>                    
                    </div> */}
                </div>                    
            </div>
        </Navbar>
    );
};

export default ModuleOne;