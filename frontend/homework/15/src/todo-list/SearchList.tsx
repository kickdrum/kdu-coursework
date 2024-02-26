import React from 'react';
import './Search.scss';
import { useDispatch } from 'react-redux';
import { setSearchTerm } from '../redux/todoSlice';

export function SearchList() {
  const dispatch = useDispatch();

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    dispatch(setSearchTerm(e.target.value));
  };

  return (
    <div>
      <input
        className="search"
        type="text"
        placeholder="Search Items..."
        onChange={handleSearchChange}
      />
    </div>
  );
}

