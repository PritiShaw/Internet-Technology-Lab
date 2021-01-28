import React from 'react';
import { Navbar} from 'react-bootstrap';

const ModuleOne = ({toggleAdmin}) =>{       
    return(
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home" style={{fontSize:"xxx-large", fontWeight: "bolder"}}>NearBy Stores</Navbar.Brand>            
            <div className="ml-auto">
                <span className="input-group-text btn btn-primary ml-2" onClick={()=>toggleAdmin(false)}>Home</span>          
            </div>
        </Navbar>
    );
};

export default ModuleOne;