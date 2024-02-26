import { configureStore } from "@reduxjs/toolkit";
import { searchReducer } from "./SearchSlice";
import { todoListReducer } from "./TodoSlice";
import { todoInputReducer } from "./TodoInputSlice";

export const store = configureStore({
    reducer:{
        search : searchReducer,
        todoList : todoListReducer,
        todoInput: todoInputReducer
    }
})


export type RootState = ReturnType<typeof store.getState>