import React, { useState, KeyboardEvent } from 'react';
import { useItemContext } from '../../context/ItemContext';
import './AddItem.scss';

const AddItem: React.FC = () => {
    const { allTodoItems, setAllTodoItems } = useItemContext();
    const [addInput, setAddInput] = useState<string>('');

    const handleAddItemClick = () => {
        if (addInput.trim() === '') {
            return;
        }

        setAllTodoItems([...allTodoItems, addInput]);
        setAddInput('');
    };

    const handleKeyPress = (event: KeyboardEvent<HTMLInputElement>) => {
        if (event.key === 'Enter') {
            handleAddItemClick();
        }
    };

    return (
        <div className='add-item-container'>
            <h2 className='add-heading'>Add Items</h2>
            <div className='add-item-input-container'>
                <input
                    type='text'
                    value={addInput}
                    onChange={(event) => setAddInput(event.target.value)}
                    onKeyDown={handleKeyPress}
                />
                <button type='button' onClick={handleAddItemClick}>
                    Submit
                </button>
            </div>
        </div>
    );
};

export default AddItem;
