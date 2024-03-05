import React, {useState } from 'react';
import './App.css';
import Navbar from './components/Navbar';

import ItemContainer from './components/ItemManger/ItemContainer';
import { SearchContext } from './context/SearchContext';



function App() {
  const [searchQuery, setSearchQuery] = useState('');
  return (
    <div className="App">
        <SearchContext.Provider value={{ searchQuery, setSearchQuery }}>
        <Navbar />
        <ItemContainer/>
      </SearchContext.Provider>
    </div>
  );
}

export default App;
