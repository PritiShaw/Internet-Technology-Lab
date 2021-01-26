import React from 'react';
import {MapContainer, TileLayer, Marker} from 'react-leaflet';
const ModuleTwo=()=>{
    return(
        <MapContainer style={{height: "100px", width: "100px"}} center={[51.505, 0.09]} zoom={13} scrollWheelZoom={false}>
            <TileLayer
                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            <Marker position={[51.505, -0.09]}>
            </Marker>
        </MapContainer>
    );
};

export default ModuleTwo;