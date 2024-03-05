import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { Stocks } from "../../types/Stocks";
import { getStocks } from "../thunks/GetStocks";

interface StocksState {
  stocks: Stocks[];
  state: "fulfilled" | "pending" | "error";
  error?: string;
}

const initialState: StocksState = {
  stocks: [],
  state: "pending",
};

const StocksSlice = createSlice({
  name: "stocks",
  initialState: initialState,
  reducers: {},
  extraReducers(builder) {
    builder
      .addCase(getStocks.pending, (state) => {
        state.state = "pending";
      })
      .addCase(
        getStocks.fulfilled,
        (state, action: PayloadAction<Stocks[]>) => {
          state.state = "fulfilled";
          state.stocks = action.payload;
        }
      )
      .addCase(getStocks.rejected, (state, action) => {
        state.error = action.payload as string;
        state.state = "error";
      });
  },
});

export default StocksSlice.reducer;
