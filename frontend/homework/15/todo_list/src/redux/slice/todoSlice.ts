import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { ITodoItem } from "../../types/todoType";
import {v4 as uuidv4} from 'uuid';

const initialState = [] as ITodoItem[];

const todoSlice = createSlice({
    name: "todos",
    initialState,
    reducers : {
        addTodo: {
            reducer: (state, action: PayloadAction<ITodoItem>) => {
                state.push(action.payload);
            },
            prepare: (content: string) => ({
                payload: {
                    id: uuidv4(),
                    content,
                    completed: false,
                } as ITodoItem
            }),
        },
        removeTodo: {
            reducer: (state, action: PayloadAction<string>) => {
                const index = state.findIndex((todoItem) => todoItem.id === action.payload);
                state.splice(index,1);
            },
            prepare: (id: string) => ({
                payload: id
            })
        },
        toogleTodo: {
            reducer: (state,action: PayloadAction<string>) => {
                const index = state.findIndex((todoItem) => todoItem.id === action.payload);
                state[index].completed = !state[index].completed;
            },
            prepare: (id:string) => ({
                payload:id
            })
        },
        removeCompleted: {
            reducer: (state) => {
                return state.filter((todoItem: ITodoItem) => (
                    !todoItem.completed
                ))
            },
            prepare: () => ({
                payload:null
            })
        }
    }
})

export const {addTodo,removeTodo, toogleTodo, removeCompleted } = todoSlice.actions;
export default todoSlice.reducer;