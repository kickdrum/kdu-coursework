import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Marketplace from './components/Marketplace';
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Marketplace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
