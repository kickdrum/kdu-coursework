import React from "react";
import { useItemContext } from "../../context/ItemContext";
import './RemoveItemButton.scss'
interface IButtonContent {
    todoContent: string;
}

const RemoveItemButton:React.FC<IButtonContent> = (props: IButtonContent) => {
    const { allTodoItems,setAllTodoItems } = useItemContext();

    const handleRemoveItemButtonClick = (
        event: React.MouseEvent<HTMLButtonElement>
    ) => {
        const myButton = event.target as HTMLButtonElement;
        const todoContent = myButton.getAttribute("data-todo-content");
        if (todoContent != null) {
            const updatedTodoItems = allTodoItems.filter(
                (item) => item !== todoContent
            );
            setAllTodoItems(updatedTodoItems);
        }
    };

    return (
        <button
            className="remove-item-button"
            type="button"
            onClick={handleRemoveItemButtonClick}
            data-todo-content={props.todoContent}
        >X</button>
    );
};

export default RemoveItemButton;
