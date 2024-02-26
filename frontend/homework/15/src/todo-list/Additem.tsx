import { useState } from 'react';
import './AddItem.scss';
import { useDispatch } from 'react-redux';
import { addTodo } from '../redux/todoSlice';

export function AddItem() {
  const [inputText, setInputText] = useState('');
  const dispatch = useDispatch();

  const handleAddItem = () => {
    dispatch(addTodo(inputText));
    setInputText('');
  };

  return (
    <div className="add-item">
      <input
        type="text"
        className="add-input"
        value={inputText}
        onChange={(e) => setInputText(e.target.value)}
      />
      <button id="add" className="add" onClick={handleAddItem}>
        Submit
      </button>
    </div>
  );
}
