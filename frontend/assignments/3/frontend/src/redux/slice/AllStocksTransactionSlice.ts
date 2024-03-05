import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { StocksTransactions } from "../../types/AllStocksTransaction";
import { getAllStocksTransactions } from "../thunks/GetAllStocksTransaction";
interface AllStocksTransactionsState {
  allStocksTransactions: StocksTransactions[];
  state: "fulfilled" | "pending" | "error";
  error?: string;
}
const initialState: AllStocksTransactionsState = {
  allStocksTransactions: [],
  state: "pending",
};

const AllStocksTransactionSlice = createSlice({
  name: "AllStocksTransaction",
  initialState: initialState,
  reducers: {},
  extraReducers(builder) {
    builder
      .addCase(getAllStocksTransactions.pending, (state) => {
        state.state = "pending";
      })
      .addCase(
        getAllStocksTransactions.fulfilled,
        (state, action: PayloadAction<StocksTransactions[]>) => {
          state.state = "fulfilled";
          state.allStocksTransactions = action.payload;
        }
      )
      .addCase(getAllStocksTransactions.rejected, (state, action) => {
        state.state = "error";
        state.error = action.payload as string;
      });
  },
});

export default AllStocksTransactionSlice.reducer;
