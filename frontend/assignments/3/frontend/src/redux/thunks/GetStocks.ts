import { createAsyncThunk } from "@reduxjs/toolkit";

export const getStocks = createAsyncThunk("getStocks", async () => {
  try {
    const response = await fetch(
      "https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/stocks.json"
    );
    const data = await response.json();
    return data;
  } catch {
    return "Error while making API call";
  }
});
