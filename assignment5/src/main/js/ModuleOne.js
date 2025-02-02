import React from 'react';
import { Navbar} from 'react-bootstrap';

const ModuleOne = ({category, setCategory, toggleAdmin}) =>{   
    
    
    return(
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home" style={{fontSize:"xxx-large", fontWeight: "bolder"}}>NearBy Stores</Navbar.Brand>            
            <div className="ml-auto">
                <div className=" input-group">
                    <select className="form-control d-inline" value={category} onChange={(e)=>setCategory(e.target.value)}>
                        <option hidden>Choose Category</option>
                        <option value={1}>Medical Store</option>
                        <option value={2}>Grocery Store</option>
                        <option value={3}>Hospital</option>
                        <option value={4}>Petrol Station</option>
                        <option value={5}>Hardware Store</option>
                    </select>
                    <div className="input-group-append">
                        <span className="input-group-text btn btn-primary ml-2" onClick={()=>toggleAdmin(true)}>Admin</span>
                    </div>
                </div>                    
            </div>
        </Navbar>
    );
};

export default ModuleOne;