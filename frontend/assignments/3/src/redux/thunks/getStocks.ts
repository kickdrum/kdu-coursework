import { createAsyncThunk } from '@reduxjs/toolkit';

interface Stock {
  stock_name: string;
  stock_symbol: string;
  base_price: number;
}

export const fetchStocks = createAsyncThunk<Stock[]>(
  'getStocks',
  async () => {
    try {
      const response = await fetch('https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/stocks.json');
      const data = await response.json();
      return data as Stock[]; 
    } catch (error) {
      throw new Error('Error while making API call');
    }
  }
);
