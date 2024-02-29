import { createSlice, PayloadAction } from "@reduxjs/toolkit";

const initialState = "" as string;

const searchSlice = createSlice({
    name: "search",
    initialState,
    reducers: {
        setSearchText: {
            reducer: (_,action: PayloadAction<string>) => {
                return action.payload;
            },
            prepare : (searchText: string) => (
                {
                    payload:searchText
                }
            )
        }
    }
})


export const {setSearchText} = searchSlice.actions;
export default searchSlice.reducer;