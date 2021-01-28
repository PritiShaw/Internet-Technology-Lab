import React from 'react';
import {MapContainer, TileLayer, Marker, useMap, Popup} from 'react-leaflet';


const ModuleTwo=({cords, center})=>{    
    return(
        <MapContainer center={[22.57,88.36]} zoom={10}>
            <TileLayer
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {
                cords.map((dot)=><Marker key={dot} position={[dot[0],dot[1]]}>
                                    <Popup>
                                        <b>{dot[2]}</b>
                                        <hr/>
                                        <a target="_blank" href={"https://maps.google.com/?daddr=" + dot[0] + "," + dot[1]}>
                                            Directions
                                        </a>
                                    </Popup>
                                </Marker>
                )
            }            
        </MapContainer>
    );
};

export default ModuleTwo;