import { useEffect, useState } from "react";
import {Hobbies} from "./Hobbies";
import {Info} from "./Info";
import {Skills} from "./Skills";
import { fetchPayload, IPayload } from './api';
import './main.css'

export default function UserUI() {
    const [lists, setLists] = useState<IPayload | null>(null);

    useEffect(() => {
        async function fetchData() {
            const data = await fetchPayload();
            setLists(data);
        }
        fetchData();
    }, []);


    if (lists === null) {
        return <div>Loading...</div>;
    }
    return (
        <div className="main">
            <Info name={lists.name} fullName={lists.fullName} qualification={lists.qualification} />
            <div className="info-2">
                <Skills skills={lists.skills}/>
                <Hobbies hobbies={lists.hobbies}/>
            </div>
        </div>
    )
}
