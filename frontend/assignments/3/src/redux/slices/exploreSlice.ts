import { createSlice } from '@reduxjs/toolkit';
import { fetchStocks } from '../thunks/getStocks';

interface Stock {
  stock_name: string;
  stock_symbol: string;
  base_price: number;
}

interface ExploreState {
  stocks: Stock[];
  loading: boolean;
  error: string | null;
}

const initialState: ExploreState = {
  stocks: [],
  loading: false,
  error: null,
};

const exploreSlice = createSlice({
  name: 'explore',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(fetchStocks.pending, (state) => {
        state.loading = true;
        state.error = null;
      })
      .addCase(fetchStocks.fulfilled, (state, action) => {
        state.loading = false;
        state.stocks = action.payload;
      })
      .addCase(fetchStocks.rejected, (state, action) => {
        state.loading = false;
        state.error = action.error.message ?? 'Error while making API call';
      });
  },
});

export default exploreSlice.reducer;
