import React, { useState } from 'react';
import './AddItem.scss'

export interface IListItem {
    id: number;
    text: string;
}

interface ListProps {
    list: IListItem[];
    setList: React.Dispatch<React.SetStateAction<IListItem[]>>
}

export function AddItem({list, setList}: ListProps) {
    const [inputText, setInputText] = useState('');

    const handleAddItem=()=>{
        const newItem: IListItem= {id: list.length+1,text:inputText};
        setList([...list, newItem]);
    }
  return (
    <div className="add-item">
        <input
            type="text"
            className='add-input'
            value={inputText}
            onChange={(e) => setInputText(e.target.value)}
        />
        <button id="add" className="add" onClick={handleAddItem}>Submit</button>
    </div>
  );
};