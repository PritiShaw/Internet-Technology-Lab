import React, {useEffect, useState} from 'react';

const ModuleThree=({category, setCords, setCenter})=>{    
    const [stores, setStores] = useState([])
    const [name, setName] = useState("")
    useEffect(() => {
        dataLoader()
    }, [category])

    const dataLoader = async () => {
        const response = await fetch("/api/categories/" + category)
        const body = await response.json()
        setStores(body.stores)
        setName(body.name)
        var center = [0,0]
        var cords = []
        body.stores.map((e)=>{
            center[0] += e.latitude
            center[1] += e.longitude 
            cords.push([e.latitude,e.longitude,e.storeName])
        })
        if(cords.length>0){
            center[0] /= cords.length
            center[1] /= cords.length
        }
        setCords(cords)
        setCenter(center)
    }

    const Result = () => {
        return  (<>
                    <h1>List of {name}</h1>
                    <table className="table">
                        <thead>
                            <tr><th>Name</th><th>Timings</th></tr>
                        </thead>
                        <tbody>
                    {
                        stores.map((e)=><tr key={e.storeName}><td>{e.storeName}</td><td>{e.openTime} - {e.closeTime}</td></tr>)
                    }
                        </tbody>
                    </table>
                </>)
    }
    return(
        category>0?<Result/>:<p className="text-center display-2">Select Category</p>
    );
};

export default ModuleThree;