import React from 'react';

const Admin = ({ category, setCategory }) => {
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
                                    <input className="form-control" name="departure" type="text" id="adminDeparture" list="airport_codes" autoComplete="off" />
                                    <label htmlFor="fromInput" id="adminDeparture">Store Name</label>
                                </div>
                            </div>
                            <div className="col">
                                <div className="md-form">
                                    <select className="form-control d-inline" value={category} onChange={(e) => setCategory(e.target.value)}>
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
                                        <input className="form-control" id="exp" type="time" required name="expiry" />
                                        <label className="active" htmlFor="expiry">Opens At</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" id="exp" type="time" required name="expiry" />
                                        <label className="active" htmlFor="expiry">Closed At</label>
                                    </div>
                                </div>
                            </div>
                            <div className="form-row ">
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" name="departure" type="text" id="adminDeparture" list="airport_codes" autoComplete="off" />
                                        <label htmlFor="fromInput" id="adminDeparture">GPS Location(Longitude)</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" name="arrival" type="text" id="arrivalDeparture" list="airport_codes" autoComplete="off" />
                                        <label htmlFor="fromInput" id="arrivalDeparture">GPS Location(Latitude)</label>
                                    </div>
                                </div>
                            </div>
                            <div className="form-row mt-2">
                                <div className="col">
                                    <div className="md-form">
                                        <input className="form-control" type="password" id="password" required name="password" />
                                        <label htmlFor="password">Password</label>
                                    </div>
                                </div>
                            </div>
                            <button className="btn btn-block btn-primary" value="submit" >Submit</button>
                            </div>
                            {/* <p class="w-100 text-success lead text-center py-2 mb-0">
                            <span>Success</span>
                        </p> */}
                        </form>
                    </div>
                </div>
    </>
    );
};

export default Admin;