import '../../styles/common.scss';
import './MainBox.scss'
import { CheckList } from '../CheckListComponent/CheckList'
import { useState } from 'react';


interface ITodoItem {
    id: number;
    content: string;
    isValid: boolean;
}

interface IMainBoxProps {
    todoData: ITodoItem[];
    setTodoData: React.Dispatch<React.SetStateAction<ITodoItem[]>>;
}

export const MainBox = ({ todoData, setTodoData }: IMainBoxProps) => {

    const [inputValue, setInputValue] = useState("");

    const submitHandler = () => {

        const newData = {
            id: todoData.length + 1,
            content: inputValue,
            isValid: true
        }

        setTodoData([...todoData, newData]);
        setInputValue("");
    }

    const handleChange = (event: any) => {
        setInputValue(event.target.value);
    }

    const deleteTodo = (id: number) => {

        const updatedData = todoData.filter((curr)=>{
            return curr.id !== id;
        });

        setTodoData(updatedData);
    }

    return (

        <div className='mainBox'>

            <div className="todoInputBox">
                <h2 className='heading2'>Add Items</h2>
                <input id='addTodoInputBox' type="text" onChange={handleChange} value={inputValue} />
                <button id='addTodoSubmitButton' onClick={submitHandler}>Submit</button>
            </div>

            <div className="todoDisplayBox">
                <h2 className='heading2'>Items</h2>
                <CheckList todoData={todoData} deleteTodo={deleteTodo} />
            </div>

        </div>
    )
}
