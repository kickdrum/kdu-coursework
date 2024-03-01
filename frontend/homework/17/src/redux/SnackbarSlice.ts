import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { getProducts } from "../thunks/getProducts";

interface SnackbarState{
    show: boolean;
    message: string;
}

const initialState: SnackbarState={
    show: false,
    message: ""
}
export const snackBarSlice= createSlice({
    name: "snackbar",
    initialState,
    reducers:{
        sentMessage: (state, action: PayloadAction<string>)=>{
            state.message= action.payload
        },
        setClose: (state)=>{
            state.show=false
        }
    },
    extraReducers(builder){
        builder.addCase(getProducts.fulfilled, (state)=>{
            state.message="Products loaded sucessfully";
            state.show=true;
        }).addCase(getProducts.rejected,(state, action)=>{
            state.message=action.payload as string;
            state.show=true;
        })
    }
})

export const {sentMessage, setClose} = snackBarSlice.actions;
export default snackBarSlice.reducer;  