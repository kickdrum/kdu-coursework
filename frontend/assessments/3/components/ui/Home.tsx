import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/Store";
import { Addons } from "./Addons";
import { DateSelection } from "./DateSelection";
import { Room } from "./RoomType";
import { useEffect } from "react";
import { fetchRoomData } from "../redux/Thunk";
import { Price } from "./Price";

export  function Home() {
    const dispatch:AppDispatch=useDispatch();
    useEffect(()=>{
        try{
            dispatch(fetchRoomData());
        }
        catch(error)
        {
            console.error(error)
        }
    },[])


    const roomItems=useSelector((state:RootState)=>state.rooms.roomItems)
    console.log("Roomitems: ",roomItems,"type",roomItems.map((room)=>room.name))
  return (
    <div>
        <Room/>
        <DateSelection/>
        <Addons/>
        <Price/>

    </div>
  )
}
