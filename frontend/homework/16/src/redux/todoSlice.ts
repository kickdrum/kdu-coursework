import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface TodoItem {
  id: number;
  name: string;
}

interface TodoAppState {
  items: TodoItem[];
  searchTerm: string;
}

const initialState: TodoAppState = {
  items: [
    { id: 1, name: "Task 1" },
    { id: 2, name: "Task 2" },
    { id: 3, name: "Task 3" },
  ],
  searchTerm: "",
};

const todoSlice = createSlice({
  name: "todo",
  initialState,
  reducers: {
    addItem: (state, action: PayloadAction<string>) => {
      const newItemObject: TodoItem = {
        id: Math.random(),
        name: action.payload,
      };
      state.items.push(newItemObject);
    },
    deleteItem: (state, action: PayloadAction<number>) => {
      state.items = state.items.filter((item) => item.id !== action.payload);
    },
    setSearchTerm: (state, action: PayloadAction<string>) => {
      state.searchTerm = action.payload;
    },
  },
});

export const { addItem, deleteItem, setSearchTerm } = todoSlice.actions;
export default todoSlice.reducer;
