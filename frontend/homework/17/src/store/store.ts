import { configureStore } from '@reduxjs/toolkit';
import productsReducer from '../redux/ProductsSlice';
import snackbarReducer from '../redux/SnackbarSlice';

export const store = configureStore({
  reducer:{
  products: productsReducer,
  snackbar: snackbarReducer
  }
});

export type RootState= ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch;