import { configureStore, combineReducers } from "@reduxjs/toolkit";
import todoReducer from './slice/todoSlice';
import searchReducer from './slice/searchSlice';

export const store = configureStore({
    reducer: combineReducers({
        todos: todoReducer,
        search: searchReducer

    })
})

export type StoreDispatch = typeof store.dispatch;
export type StoreState = ReturnType<typeof store.getState>;