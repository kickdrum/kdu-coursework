import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface SnackBarState {
  show: boolean;
  message: string;
}

const initialState: SnackBarState = {
  show: false,
  message: "",
};

const SnackbarSlice = createSlice({
  name: "snackBar",
  initialState: initialState,
  reducers: {
    setShow(state, action: PayloadAction<boolean>) {
      state.show = action.payload;
    },
    setMessage(state, action: PayloadAction<string>) {
      state.message = action.payload;
    },
  },
});

export const { setMessage, setShow } = SnackbarSlice.actions;
export default SnackbarSlice.reducer;
