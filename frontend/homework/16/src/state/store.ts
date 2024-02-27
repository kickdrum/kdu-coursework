import {configureStore} from '@reduxjs/toolkit';
import {todoListReducer} from './Reducer/toDoListSlice';
import storage from "redux-persist/lib/storage";
import { persistReducer, persistStore } from "redux-persist";


const persistConfig = {
    key: "root",
    storage,
  };
  
  const persistedReducer = persistReducer(persistConfig, todoListReducer);
  export const store = configureStore({
    reducer: {
      todoList: persistedReducer,
    },
  });
  
  export type RootState = ReturnType<typeof store.getState>;
  export const persistorList = persistStore(store);