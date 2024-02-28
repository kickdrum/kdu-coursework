// import { BrowserRouter, Routes, Route } from "react-router-dom";
// import ProductListPage from "./ProductListPage";
// import ProductDetailPage from "./ProductDetailPage";
// import { ProductsProvider } from "./ProductsContext";

import { Marketplace } from "./components/Marketplace";

function App() {
  return (
    // <ProductsProvider>
    //     <BrowserRouter>
    //       <Routes>
    //           <Route path="/" element={<ProductListPage/>} />
    //           <Route path="/product/:productId" element={<ProductDetailPage/>} />
    //       </Routes>
    //     </BrowserRouter>
    // </ProductsProvider>
    <Marketplace/>
  );
}

export default App;
