import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { ITodoItem } from "../interfaces/ITodoItem";

interface TodoListState {
    todoList: ITodoItem[];
}

const initialState: TodoListState = {
    todoList: []
}

const todoListSlice = createSlice({
    name:"todoLost",
    initialState: initialState,
    reducers: {
        setTodoList:(state, action: PayloadAction<ITodoItem[]>)=>{
            state.todoList = action.payload;
        }
    }
});

export const todoListReducer = todoListSlice.reducer;

export const {setTodoList} = todoListSlice.actions;
