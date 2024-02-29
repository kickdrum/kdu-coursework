import React, { useState } from "react";
import RemoveItemButton from "../RemoveItemButton/RemoveItemButton";
import "./Item.scss";
import { useDispatch } from "react-redux";
import { toogleTodo } from "../../redux/slice/todoSlice";

export interface PropItem {
    todoContent: string;
    id: string;
}

const Item: React.FC<PropItem> = (props: PropItem) => {

    const dispatch = useDispatch();
    const [checked, setChecked] = useState(false);

    const handleCheckboxChange = (
        event: React.ChangeEvent<HTMLInputElement>
    ) => {
        const todoId = event.target.getAttribute("data-todo-id");
        dispatch(toogleTodo(todoId!));
        setChecked(!checked);
    };

    return (
        <div className="item-container">
            <div className="todo-content-container">
                <input
                    type="checkbox"
                    id={`todo-status${props.id}`}
                    onChange={handleCheckboxChange}
                    data-todo-id={props.id}
                />
                <label htmlFor={`todo-status${props.id}`}>
                    <p
                        className={`todo-content ${
                            checked ? "todo-complete" : null
                        }`}
                    >
                        {props.todoContent}
                    </p>
                </label>
            </div>
            <RemoveItemButton id={props.id} />
        </div>
    );
};

export default Item;
