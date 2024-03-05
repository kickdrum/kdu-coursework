import { StockName } from "./../../types/PortfolioTransaction";
import { createSlice } from "@reduxjs/toolkit";
import { Status } from "../../types/PortfolioTransaction";

interface FilterState {
  search: string;
  status: Status | null;
  StockName: Set<StockName>;
  beginDate: Date | null;
  EndDate: Date | null;
}

const initialState: FilterState = {
  search: "",
  status: null,
  StockName: new Set(),
  beginDate: null,
  EndDate: null,
};

const FilterSlice = createSlice({
  name: "filter",
  initialState: initialState,
  reducers: {
    clearAll: (state) => {
      state.search = "";
      state.status = null;
      state.StockName = new Set();
      state.beginDate = null;
      state.EndDate = null;
    },
  },
});
export const { clearAll } = FilterSlice.actions;
export default FilterSlice.reducer;
