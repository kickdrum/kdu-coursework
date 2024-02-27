import { configureStore } from '@reduxjs/toolkit';
import todoReducer from './todoSlice';
import storage from 'redux-persist/lib/storage'
import {combineReducers} from "redux"; 
import { persistReducer } from 'redux-persist'


const persistConfig = {
  key: 'root',
  storage
};

const reducers = combineReducers({
  todo: todoReducer, 
 });


const persistedReducer = persistReducer(persistConfig, reducers);

export const store = configureStore({
  reducer:persistedReducer,

});

export type RootState = ReturnType<typeof store.getState>;

