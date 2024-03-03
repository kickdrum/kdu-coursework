// walletSlice.ts

import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface WalletState {
  balance: number;
}

const initialState: WalletState = {
  balance: 50000, // Initial wallet balance
};

const walletSlice = createSlice({
  name: 'wallet',
  initialState,
  reducers: {
    updateWallet: (state, action: PayloadAction<number>) => {
      state.balance = action.payload;
    },
  },
});

export const { updateWallet } = walletSlice.actions;
export default walletSlice.reducer;
