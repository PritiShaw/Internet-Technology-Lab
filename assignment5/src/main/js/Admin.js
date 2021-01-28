import React,{useState} from 'react';

const Admin = () => {
    const [storeName, setStoreName] = useState();
    const [open, setOpen] = useState();
    const [close, setClose] = useState();
    const [category, setCategory] = useState();
    const [longitude, setLongitude] = useState();
    const [latitude, setLatitude] = useState();
    const [password, setPassword] = useState();
    const [message, setMessage] = useState()

    const handleStoreName = (e) => {
        e.preventDefault();
        setStoreName(e.target.value);
    }
    const handleOpen = (e) => {
        e.preventDefault();
        setOpen(e.target.value);
    }
    const handleClose = (e) => {
        e.preventDefault();
        setClose(e.target.value);
    }
    const handleLongitude = (e) => {
        e.preventDefault();
        setLongitude(e.target.value);
    }
    const handleLatitude = (e) => {
        e.preventDefault();
        setLatitude(e.target.value);
    }
    const handlePassword = (e) => {
        e.preventDefault();
        setPassword(e.target.value);
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        const result = await fetch("/api/addStore", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "storeName": storeName,
                "cid": category,
                "openTime": open,
                "closeTime": close,
                "longitude": longitude,
                "latitude": latitude,
                "pass": password
            })
        })
        const body = await result.json()
        setMessage(body.status);
    }

    return (
        <>
            <div className="container">
                <p className="display-4 text-center">Admin Panel</p>
                <div className="col-6 offset-3 bg-white shadow border rounded mb-5 pb-3 ">
                    <p className="h3 text-center mt-4 mb-1">Add Store</p>
                    <form className="pt-4 px-3">
                        <div className="form-row ">
                            <div className="col">
                                <div className="md-form">
                                    <input className="form-control" required name="storeName" type="text" autoComplete="off" value={storeName} onChange={handleStoreName} />
                                    <label htmlFor="fromInput" id="adminDeparture">Store Name</label>
                                </div>
                            </div>
                            <div className="col">
                                <div className="md-form">
                                    <select className="form-control d-inline" value={category}  onChange={(e)=>setCategory(e.target.value)}>
                                        <option hidden>Choose Category</option>
                                        <option value={1}>Medical Store</option>
                                        <option value={2}>Grocery Store</option>
                                        <option value={3}>Hospital</option>
                                        <option value={4}>Petrol Station</option>
                                        <option value={5}>Hardware Store</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div className="form-row mt-2">
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" type="time" required name="open" value={open} onChange={handleOpen} />
                                        <label className="active" htmlFor="expiry">Opens At</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" type="time" required name="close" value={close} onChange={handleClose} />
                                        <label className="active" htmlFor="expiry">Closed At</label>
                                    </div>
                                </div>
                            </div>
                            <div className="form-row ">
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" required name="longitude" type="text" autoComplete="off" value={latitude} onChange={handleLatitude} />
                                        <label htmlFor="fromInput" id="adminDeparture">GPS Location(Longitude)</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" required name="latitude" type="text" autoComplete="off" value={longitude} onChange={handleLongitude} />
                                        <label htmlFor="fromInput" id="arrivalDeparture">GPS Location(Latitude)</label>
                                    </div>
                                </div>
                            </div>
                            <div className="form-row mt-2">
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" type="password" required name="password" value={password} onChange={handlePassword} />
                                        <label htmlFor="password">Password</label>
                                    </div>
                                </div>
                            </div>
                            <button className="btn btn-block btn-primary" value="submit" onClick={handleSubmit}>Submit</button>
                        </div>
                        <p class="w-100 text-primary lead text-center py-2 mb-0">
                            {message}
                        </p>
                    </form>
                </div>
            </div>
        </>
    );
};

export default Admin;   