import React from 'react';
import { Provider } from 'react-redux';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import store from '../store/store';
import ProductList from './ProductList';
import Navbar from './Navbar';

const Marketplace = () => {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<ProductList />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
};

export default Marketplace;
