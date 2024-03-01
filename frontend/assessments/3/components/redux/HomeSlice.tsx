import { fetchRoomData } from "./Thunk";
import { AddOn, RoomType, RootObject } from "../interface/RoomInterface";
import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface RoomState
{
    roomItems: RoomType[];
    loading:boolean;
    error:string|null;
    currentlySelectedRoom:RoomType|null;
    addonsSelected:AddOn[];
    dates:number
}

const initialState: RoomState={
   roomItems:[],
    loading: false,
    error:null,
    currentlySelectedRoom:null,
    addonsSelected:[],
    dates:0
}

export const roomSlice = createSlice({
    name:'room',
    initialState,
    reducers:{
    
      setCurrentlySelectedRoom:(state,action:PayloadAction<RoomType|null>)=>{
        state.currentlySelectedRoom = action.payload
      },
      setAddons:(state,action:PayloadAction<AddOn>)=>{
      
        state.addonsSelected.push(action.payload)
      },
      setDates:(state,action:PayloadAction<number>)=>{
        state.dates = action.payload
      }
    },
    extraReducers(builder)
    {
        builder.addCase(fetchRoomData.pending,(state)=>{
            state.loading = true
            state.error = null
        }).addCase(fetchRoomData.fulfilled,(state,action)=>{
            console.log("Payload",action.payload)
            state.roomItems = action.payload
            state.loading = false
            state.error = null
        }).addCase(fetchRoomData.rejected,(state,action)=>{
            state.error = action.error.message as string
            state.loading = false
        })
    }
})

export default roomSlice.reducer;
export const {setCurrentlySelectedRoom,setAddons,setDates} = roomSlice.actions