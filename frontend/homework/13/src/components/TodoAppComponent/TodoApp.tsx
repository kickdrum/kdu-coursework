import React, { useState } from 'react'
import { Header } from '../HeaderComponent/Header'
import { MainBox } from '../MainBoxComponent/MainBox'
import './TodoApp.scss';
import '../../styles/common.scss';


export const TodoApp = () => {

    const [todoData, setTodoData] = useState([
        {
            id: 1,
            content: "this is my todo 1",
            isValid: true
        },
        {
            id: 2,
            content: "this is my todo 2",
            isValid: true
        },
        {
            id: 3,
            content: "this is todo by pratham",
            isValid: true
        },
        {
            id: 4,
            content: "this is another todo by pratham",
            isValid: true
        },

    ]);

    const [searchKey, setSearchKey] = useState("");

    return (
        <div className='todoAppContainer'>
            <Header searchKey={searchKey} setSearchKey={setSearchKey} todoData={todoData} setTodoData={setTodoData}/>
            <MainBox todoData={todoData} setTodoData={setTodoData}/>
        </div>
    );

}
