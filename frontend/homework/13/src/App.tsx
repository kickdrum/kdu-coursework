
import { createContext, useState } from "react"
import { Main } from "./components/Main"
import { IItem, ProductListContextProp, ProductListContextProviderProp } from "./components/interfaces/APIInterfaces"
import "./App.css"
import { BrowserRouter as Router, Route, BrowserRouter, Routes } from "react-router-dom";
import { Item } from "./components/Item";
export const ProductListContext = createContext<ProductListContextProp>({
  products:[],
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  setList:(data :IItem[])=>{}
})


// eslint-disable-next-line @typescript-eslint/no-unused-vars
const ProductListContextProvider = ({children}:ProductListContextProviderProp)=>{
  const [products,setProducts] = useState<IItem[]>([]);
  const setList = (data:IItem[])=>{
    setProducts(data);
  }
  return(
    <ProductListContext.Provider value={{products,setList}}>
      {children}
    </ProductListContext.Provider>
  )
}
function App() {
  return (
    <BrowserRouter>
      <div className="app-container">
        <ProductListContextProvider>
          <Routes>
            <Route path="/" element={<Main/>}></Route>
            <Route path="/item/:id" element={<Item/>}></Route>
          </Routes>
        </ProductListContextProvider>
      </div>
    </BrowserRouter>
  );
}

export default App
