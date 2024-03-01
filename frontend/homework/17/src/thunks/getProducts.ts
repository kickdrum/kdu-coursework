import { createAsyncThunk } from "@reduxjs/toolkit";

export const getProducts = createAsyncThunk("getproducts", async()=>{
    try{
    const response =await fetch("https://fakestoreapi.com/products");
    const data= await response.json();
    return data;
    } catch{
        return "Error while  making api calls";
    }
});