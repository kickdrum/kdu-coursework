
import { createContext } from "react";
import { ProductProps } from "../types/ProductProps";

interface ProductContextState {
    products: ProductProps[];
    displayProducts: ProductProps[];
    selectedProduct: ProductProps | null;
    setSelectedProduct: (product: ProductProps | null) => void;
    searchQuery: string;
    setSearchQuery: (query: string) => void;
    filter: string;
    setFilter: (category: string) => void;
    sort: 'ASC' | 'DESC' | null;
    setSort: (sort: 'ASC' | 'DESC' | null) => void;
}

export const ProductContext = createContext<ProductContextState>(null!);


