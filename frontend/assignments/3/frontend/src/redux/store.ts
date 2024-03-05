import { configureStore } from "@reduxjs/toolkit";
import StocksReducer from "./slice/StocksSlice";
import WatchListReducer from "./slice/WatchListSlice";
import PortfolioTransactionReducer from "./slice/PortfolioTransactionSlice";
import AllStocksTransactionReducer from "./slice/AllStocksTransactionSlice";

export const store = configureStore({
  reducer: {
    stocks: StocksReducer,
    watchList: WatchListReducer,
    portfolioStockTransactions: PortfolioTransactionReducer,
    allStocksTransactions: AllStocksTransactionReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
