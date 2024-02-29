import React from "react";
import './RemoveItemButton.scss'
import { useDispatch } from "react-redux";
import { removeTodo } from "../../redux/slice/todoSlice";
interface IButtonContent {
    id: string
}

const RemoveItemButton:React.FC<IButtonContent> = (props: IButtonContent) => {
    const dispatch = useDispatch();

    const handleRemoveItemButtonClick = (
        event: React.MouseEvent<HTMLButtonElement>
    ) => {
        const myButton = event.target as HTMLButtonElement;
        const todoId = myButton.getAttribute("data-todo-id");
        dispatch(removeTodo(todoId!));
        
    };

    return (
        <button
            className="remove-item-button"
            type="button"
            onClick={handleRemoveItemButtonClick}
            data-todo-id={props.id}
        >X</button>
    );
};

export default RemoveItemButton;
