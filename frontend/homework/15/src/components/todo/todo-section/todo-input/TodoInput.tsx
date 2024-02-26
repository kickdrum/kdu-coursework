import "./TodoInput.scss";
import { v4 as uuidv4 } from 'uuid'; 
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../../../../redux/store';
import { setTodoList } from '../../../../redux/TodoSlice';
import { setTodoInput } from '../../../../redux/TodoInputSlice';


export function TodoInput(){
    const todoInput = useSelector((state: RootState) => state.todoInput.todoInput)
    const todoList = useSelector((state: RootState) => state.todoList.todoList);
    const dispatch = useDispatch();

    function changeHandler(event: any) {
        dispatch(setTodoInput(event.target.value));
        console.log(event.target.value);
    }

    function submitHandler(){
        if(todoInput.trim()!==""){

            const newItem = {
                id: uuidv4(), 
                text: todoInput
            };
            const updatedList = [...todoList, newItem];
            dispatch(setTodoList(updatedList));
            dispatch(setTodoInput(''));
        }
    }

       return (
        <div className="todo">
            <input 
            className="todo-input" 
            type="text" 
            value={todoInput}
            onChange={(e) => changeHandler(e)}
            />
            <button onClick={submitHandler} className="submit">Submit</button>
        </div>
    );
}