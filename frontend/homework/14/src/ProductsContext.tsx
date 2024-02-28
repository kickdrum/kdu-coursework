import { createContext,useEffect, useState } from "react";

export interface Product {
  id: number;
  title: string;
  price: number;
  description: string;
  category: string;
  image: string;
  rating: Rating;
}
  
interface Rating {
  rate: number;
  count: number;
}

export interface Context {
  list: Product[];
  setList: React.Dispatch<React.SetStateAction<Product[]>>;
  productsList: Product[];
  setProductsList: React.Dispatch<React.SetStateAction<Product[]>>;
  sorting: string;
  setSorting: React.Dispatch<React.SetStateAction<string>>;
  search: string;
  setSearch: React.Dispatch<React.SetStateAction<string>>;
}

export interface ProviderProps {
  children: React.ReactNode;
}

export const ProductsContext = createContext<Context>({
  list: [],
  setList: () => { },
  productsList: [],
  setProductsList: () => { },
  sorting: "",
  setSorting: () => { },
  search: "",
  setSearch: () => { }
})

export const ProductsProvider = ({ children }:ProviderProps) => {
  const [list, setList] = useState<Product[]>([]);
  const [productsList, setProductsList] = useState<Product[]>([]);
  const [filterInput] = useState<string>("");
  const [sorting, setSorting] = useState<string>("");
  const [search, setSearch] = useState<string>("");

  useEffect(() => {
    fetch("https://fakestoreapi.com/products")
      .then((response) => response.json())
      .then((data) => {
        setList(data);
        console.log(data);
      })
  }, [])
  
  useEffect(() => {
    let list1 = [...list];
    if (filterInput !== "") list1 = list.filter((product) => (product.category === filterInput));
    if (sorting === "asc") {
      list1.sort((a: Product, b: Product) => a.price - b.price);
    }
    else if (sorting === "desc") {
      list1.sort((a: Product, b: Product) => b.price - a.price);
    } 
    console.log(filterInput);
    setProductsList(list1);
  }, [filterInput, sorting, list])


  useEffect(() => {
    const list2 = list.filter((product) => (product.title.toLowerCase().includes(search.toLowerCase())));
    setProductsList(list2);
  },[search])


  return (
    <ProductsContext.Provider value={{ list, setList, productsList, setProductsList, sorting, setSorting, search, setSearch }}>
      {children}
    </ProductsContext.Provider>
  )
}