import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface WatchlistState {
  watchlistItems: string[];
}

const initialState: WatchlistState = {
  watchlistItems: [],
};

const WatchListSlice = createSlice({
  name: "watchlist",
  initialState: initialState,
  reducers: {
    addItemToWatchList: (state, action: PayloadAction<string>) => {
      state.watchlistItems.push(action.payload);
    },
    removeItemFromWatchList: (state, action: PayloadAction<string>) => {
      state.watchlistItems.filter((name) => name !== action.payload);
    },
  },
});
export const { addItemToWatchList, removeItemFromWatchList } =
  WatchListSlice.actions;
export default WatchListSlice.reducer;
