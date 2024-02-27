import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface ToDoListState {
  searchItem: string;
  todoList: string[];
}

const initialState: ToDoListState = {
  searchItem: "",
  todoList: [],
};

const todoListSlice = createSlice({
  name: "todoList",
  initialState: initialState,
  reducers: {
    setTodoList: (state, action: PayloadAction<string[]>) => {
      state.todoList = action.payload;
    },
    setSearchItem: (state, action: PayloadAction<string>) => {
      state.searchItem = action.payload;
    },
    handleDelete: (state, action: PayloadAction<number>) => {
      const updatedList = [...state.todoList];
      updatedList.splice(action.payload, 1);
      state.todoList = updatedList;
    },
  },
});

export const todoListReducer = todoListSlice.reducer;
export const { setTodoList, setSearchItem, handleDelete } = todoListSlice.actions;
