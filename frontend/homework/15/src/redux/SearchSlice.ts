import { PayloadAction, createSlice } from "@reduxjs/toolkit";

interface SearchBarState {
    searchBar: string;
}

const initialState: SearchBarState = {
    searchBar: ""
}

const searchBarSlice = createSlice({
    name:"searchText",
    initialState: initialState,
    reducers: {
        setSearchBar:(state, action: PayloadAction<string>)=>{
            state.searchBar = action.payload;
        }
    }
});

export const searchReducer = searchBarSlice.reducer;
export const {setSearchBar} = searchBarSlice.actions;