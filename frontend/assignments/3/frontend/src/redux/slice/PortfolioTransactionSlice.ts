import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { PortfolioStockTransactions } from "../../types/PortfolioTransaction";
import { getPortfolioTransactions } from "../thunks/GetPortfolioTransaction";

interface PortfolioStockTransactionsState {
  allPortfolioStocksTransactions: PortfolioStockTransactions[];
  state: "fulfilled" | "pending" | "error";
  error?: string;
}

const initialState: PortfolioStockTransactionsState = {
  allPortfolioStocksTransactions: [],
  state: "pending",
};

const PortfolioStockTransactionsSlice = createSlice({
  name: "PortfolioTransactions",
  initialState: initialState,
  reducers: {},
  extraReducers(builder) {
    builder
      .addCase(getPortfolioTransactions.pending, (state) => {
        state.state = "pending";
      })
      .addCase(
        getPortfolioTransactions.fulfilled,
        (state, action: PayloadAction<PortfolioStockTransactions[]>) => {
          state.state = "fulfilled";
          state.allPortfolioStocksTransactions = action.payload;
        }
      )
      .addCase(getPortfolioTransactions.rejected, (state, action) => {
        state.state = "error";
        state.error = action.payload as string;
      });
  },
});

export default PortfolioStockTransactionsSlice.reducer;
