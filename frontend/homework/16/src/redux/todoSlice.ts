import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface TodoItem {
  id: number;
  text: string;
}
 
interface TodoList {
  list: TodoItem[];
  searchTerm: string;
}

const initialState: TodoList = {
  list: [
  ],
  searchTerm: "",
};

const todoSlice = createSlice({
  name: "todo",
  initialState: initialState,
  reducers: {
    addTodo: (state, action: PayloadAction<string>) => {
      const todo = {
        id: 1 + state.list.length,
        text: action.payload,
      };
      state.list.push(todo);
    },
    removeTodo: (state, action: PayloadAction<number>) => {
      state.list = state.list.filter((todo) => todo.id !== action.payload);
    },
    setSearchTerm: (state, action: PayloadAction<string>) => {
      state.searchTerm = action.payload;
    },
  },
});

export const { addTodo, removeTodo, setSearchTerm } = todoSlice.actions;

export default todoSlice.reducer;
