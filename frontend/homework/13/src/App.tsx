
import { useEffect, useState } from 'react'
import './App.css'
import { ProductProps } from './types/ProductProps'
import ProductListPage from './pages/ProductList';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProductDetailPage from './pages/ProductDetailPage';
import { ProductContext } from './context/ProductContext';


function App() {
  const [products, setProducts] = useState<ProductProps[]>([]);
  const [selectedProduct, setSelectedProduct] = useState<ProductProps | null>(null);
  const [searchQuery, setSearchQuery] = useState('');
  const [filter, setFilter] = useState('');
  const [sort, setSort] = useState<null | 'ASC' | 'DESC'>(null);
  const [displayProducts, setDisplayProducts]= useState<ProductProps[]>([]);

  useEffect(() => {
      fetch('https://fakestoreapi.com/products')
          .then(response => response.json())
          .then(data => setProducts(data));
  }, []);

  useEffect(() => {
      const filteredProducts = products.filter(product =>
          product.title.toLowerCase().includes(searchQuery.toLowerCase()) &&
          (filter ? product.category === filter : true)
        );
      const sortedProducts = filteredProducts.sort((a, b) => {
          if (sort === 'ASC') {
            return a.price - b.price;
          } else if (sort === 'DESC') {
            return b.price - a.price;
          } else {
            return 0;
          }
        });
    setSelectedProduct(sortedProducts[0] || null);
    setDisplayProducts(sortedProducts);
   }, [products, searchQuery, filter, sort])

  return (
    <ProductContext.Provider value={{ products,displayProducts, selectedProduct, setSelectedProduct, searchQuery, setSearchQuery, filter, setFilter, sort, setSort }}>
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<ProductListPage />}/>
      <Route path='/product/:id' element={<ProductDetailPage />} />
      </Routes>
      </BrowserRouter>
      </ProductContext.Provider>
  )
}

export default App
