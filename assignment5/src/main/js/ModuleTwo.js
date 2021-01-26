import React from 'react';
import {MapContainer, TileLayer, Marker, useMap} from 'react-leaflet';


const ModuleTwo=({cords})=>{    
    return(
        <MapContainer center={[22.57,88.36]} zoom={10}>
            <TileLayer
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {
                cords.map((dot)=><Marker position={dot}/>)
            }            
        </MapContainer>
    );
};

export default ModuleTwo;