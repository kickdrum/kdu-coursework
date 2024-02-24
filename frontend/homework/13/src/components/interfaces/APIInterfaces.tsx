import { ReactNode } from "react";

export interface IItem {
    id:          number;
    title:       string;
    price:       number;
    description: string;
    category:    Category;
    image:       string;
    rating:      Rating;
}

export enum Category {
    Electronics = "electronics",
    Jewelery = "jewelery",
    MenSClothing = "men's clothing",
    WomenSClothing = "women's clothing",
}

export interface Rating {
    rate:  number;
    count: number;
}

export interface ProductListContextProviderProp{
    children : ReactNode
}

export interface ProductListContextProp{
    products : IItem[],
    setList:(data :IItem[])=>void
}

export interface SearchItemContextProp{
    searchTerm : string,
    updateSearchTerm:(data:string)=>void
}
 
export interface SearchItemContextProviderProp{
    children : ReactNode
}

export interface FilterAndSortContextProviderProp{
    children : ReactNode   
}