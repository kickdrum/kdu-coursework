import {  configureStore } from "@reduxjs/toolkit";
import HomeSlice from "./HomeSlice";

export const Store = configureStore({
    reducer:{
        rooms: HomeSlice,
    },
});
export type AppDispatch = typeof Store.dispatch;
export type RootState=ReturnType<typeof Store.getState>;