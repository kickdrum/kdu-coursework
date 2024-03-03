import { configureStore } from '@reduxjs/toolkit';
import exploreReducer from './slices/exploreSlice';
import watchListReducer from './slices/watchListSlice';
import walletReducer from './slices/walletSlice';
import transactions from './slices/transactions';


export const store = configureStore({
  reducer: {
    explore: exploreReducer,
    watchList: watchListReducer,
    wallet: walletReducer,
    transactions: transactions,

  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
