import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getProducts } from '../thunks/getProducts'
interface Product {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: {
      rate: number;
      count: number;
    };
  }

interface ProductState{
    products: Product[];
    state: "pending" | "fulfilled" | "error";
    error?: string;
}

const initialState: ProductState={
    products: [],
    state: "fulfilled"
}

export const productSlice= createSlice({
    name: "products",
    initialState,
    reducers:{ 
        setData: (state, action: PayloadAction<Product[]>)=>{
            state.products=action.payload;
            state.state="fulfilled";
        },
        setError: (state, action: PayloadAction<string>)=>{
            state.state = "error";
            state.error = action.payload;        
        }
    },
    extraReducers(builder){
        builder.addCase(getProducts.pending, (state)=>{
            state.state="pending"
        }).addCase(getProducts.fulfilled, (state, actions)=>{
            state.products=actions.payload
            state.state="fulfilled";
        }).addCase(getProducts.rejected,(state,actions)=>{
            state.error=actions.payload as string
            state.state="pending";
        })
    }
})

export const {setData, setError} = productSlice.actions;
export default productSlice.reducer;