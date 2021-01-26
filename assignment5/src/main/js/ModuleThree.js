import React, {useEffect, useState} from 'react';

const ModuleThree=({category, setCords})=>{    
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
        var cords = []
        body.stores.map((e)=>{
            cords.push([e.latitude,e.longitude])
        })
        setCords(cords)
    }

    const Result = () => {
        return  (<>
                    <h1>List of {name}</h1>
                    <table className="table">
                        <tr><th>Name</th><th>Timings</th></tr>
                    {
                        stores.map((e)=><tr><td>{e.storeName}</td><td>{e.openTime} - {e.closeTime}</td></tr>)
                    }
                    </table>
                </>)
    }
    return(
        category>0?<Result/>:<p className="text-center display-2">Select Category</p>
    );
};

export default ModuleThree;