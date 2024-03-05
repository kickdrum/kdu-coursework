import { createAsyncThunk } from "@reduxjs/toolkit";

export const getPortfolioTransactions = createAsyncThunk(
  "getPortfolioTransactions",
  async () => {
    try {
      const response = await fetch(
        "https://dev-ap301c8i2ztztzm.api.raw-labs.com/mock/s"
      );
      const data = await response.json();
      return data;
    } catch {
      return "Error while making API call";
    }
  }
);
