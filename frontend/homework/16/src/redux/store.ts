import { configureStore } from "@reduxjs/toolkit";
import { searchReducer } from "./SearchSlice";
import { todoListReducer } from "./TodoSlice";
import { persistReducer, persistStore } from 'redux-persist';
import storage from 'redux-persist/lib/storage';

import { todoInputReducer } from "./TodoInputSlice";

const persistTodoListConfig = {
    key: 'root',
    storage,
}

const persistedTodoListReducer = persistReducer(persistTodoListConfig, todoListReducer)

export const store = configureStore({
    reducer:{
        search : searchReducer,
        todoList : persistedTodoListReducer,
        todoInput: todoInputReducer
    }
})


export type RootState = ReturnType<typeof store.getState>

export const persistedTodoList = persistStore(store);