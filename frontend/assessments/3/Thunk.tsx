import { createAsyncThunk } from "@reduxjs/toolkit";
import { RoomType, RootObject } from "../interface/RoomInterface";

export const fetchRoomData  = createAsyncThunk<RoomType[]>(
    "room/fetchRoomData",
    async()=>{
        try{
        const response = await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json")
        const data = await response.json()
        if (!response.ok) {
            throw new Error('Network response was not ok');
          }
        console.log("Data fetched from API: ",data["roomTypes"])
        return data["roomTypes"]
        }
        catch(error)
        {
            console.error(error);
            throw new Error("Error fetching data from API"+(error as Error).message)
        }
    }
)