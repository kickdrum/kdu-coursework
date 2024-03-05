import { createAsyncThunk } from "@reduxjs/toolkit";

export const getAllStocksTransactions = createAsyncThunk(
  "getAllStocksTransactions",
  async () => {
    try {
      const response = await fetch(
        "https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/all-stocks-transactions.json"
      );
      const data = await response.json();
      return data;
    } catch {
      return "Error while making API call";
    }
  }
);
