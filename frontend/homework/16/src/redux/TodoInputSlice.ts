import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface TodoInputState {
    todoInput: string;
}

const initialState: TodoInputState = {
    todoInput: ""
}

const todoInputSlice = createSlice({
    name:"todoInputText",
    initialState: initialState,
    reducers: {
        setTodoInput:(state, action: PayloadAction<string>)=>{
            state.todoInput = action.payload;
        }
    }
});

export const todoInputReducer = todoInputSlice.reducer;
export const {setTodoInput} = todoInputSlice.actions;