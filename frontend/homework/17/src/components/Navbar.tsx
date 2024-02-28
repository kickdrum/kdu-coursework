import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { setSearch, setSorting } from '../store/actions';

const Navbar = () => {
  const dispatch = useDispatch();
  const [searchInput, setSearchInput] = useState('');
  const [sortOption, setSortOption] = useState('');

  const handleSearch = () => {
    dispatch(setSearch(searchInput));
  };

  const handleSort = (e) => {
    setSortOption(e.target.value);
    dispatch(setSorting(e.target.value));
  };

  return (
    <div>
      <div>
        <input type="text" placeholder="Search.." value={searchInput} onChange={(e) => setSearchInput(e.target.value)} />
        <button onClick={handleSearch}>
          <img src="./search.png" alt="searchLogo" />
        </button>
      </div>
      <div>
        <div>
          <p>Sort: </p>
          <select name="" id="" value={sortOption} onChange={handleSort}>
            <option value="">None</option>
            <option value="asc">ASC</option>
            <option value="desc">DESC</option>
          </select>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
