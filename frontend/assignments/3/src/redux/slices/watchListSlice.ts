import { createSlice } from '@reduxjs/toolkit';

interface Stock {
  stock_name: string;
  stock_symbol: string;
  base_price: number;
}

interface WatchListState {
  watchList: Stock[];
}

const initialState: WatchListState = {
  watchList: [],
};

const watchListSlice = createSlice({
  name: 'watchList',
  initialState,
  reducers: {
    addStock(state, action) {
      state.watchList.push(action.payload);
    },
    removeStock(state, action) {
      state.watchList = state.watchList.filter(stock => stock.stock_symbol !== action.payload);
    },
  },
});

export const { addStock, removeStock } = watchListSlice.actions;
export default watchListSlice.reducer;
