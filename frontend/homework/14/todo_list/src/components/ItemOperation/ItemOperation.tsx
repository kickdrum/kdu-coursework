import React, { useState, KeyboardEvent } from "react";
import "./ItemOperation.scss";
import { useDispatch } from "react-redux";
import { addTodo, removeCompleted } from "../../redux/slice/todoSlice";

const AddItem: React.FC = () => {
    const dispatch = useDispatch();

    const [addInput, setAddInput] = useState<string>("");

    const handleAddItemClick = () => {
        if (addInput.trim() === "") {
            return;
        }

        dispatch(addTodo(addInput));
        setAddInput("");
    };

    const handleRemoveCompletedItemClick = () => {
        dispatch(removeCompleted());
    }

    const handleKeyPress = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key === "Enter") {
            handleAddItemClick();
        }
    };

    return (
        <div className="add-item-container">
            <h2 className="add-heading">Add Items</h2>
            <div className="add-item-input-container">
                <input
                    type="text"
                    value={addInput}
                    onChange={(event) => setAddInput(event.target.value)}
                    onKeyDown={handleKeyPress}
                />
                <button type="button" onClick={handleAddItemClick}>
                    Submit
                </button>
                <button type="button" onClick={handleRemoveCompletedItemClick}>Remove Completed Tasks</button>
            </div>
        </div>
    );
};

export default AddItem;
