import { BrowserRouter, Route, Routes } from "react-router-dom";
import { ProductList } from "./ProductList";
import { ProductsProvider } from "../ProductsContext";
import {ProductDetailPage} from "./ProductDetailPage";
import { Navbar } from "./Navbar";
import './Marketplace.scss';

export function Marketplace() {
  return (
    <ProductsProvider>
        <BrowserRouter>
            <Navbar/>
            <Routes>
                <Route path="/" element={<ProductList/>}/>
                <Route path="/detail/:id" element={<ProductDetailPage/>}/>
            </Routes>
        </BrowserRouter>
    </ProductsProvider>
  )
}
