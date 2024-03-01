import { useDispatch, useSelector } from "react-redux";
import { FlexParent, OrangeComponent, ReusableDiv } from "./csshelpers";
import { AppDispatch, RootState } from "../redux/Store";
import { AddOn, RoomType } from "../interface/RoomInterface";
import { setAddons } from "../redux/HomeSlice";

export function Addons() {
    const dispatch:AppDispatch=useDispatch();

    const roomItems=useSelector((state:RootState)=>state.rooms.roomItems)
    const currentlyPresentAddOns = useSelector((state:RootState)=>state.rooms.addonsSelected)
    const currentlySelectedRoom=useSelector((state:RootState)=>state.rooms.currentlySelectedRoom)
    const setAddonHandler = (addOn:AddOn)=>{
        console.log(addOn)
        if(!currentlyPresentAddOns.includes(addOn)){
            dispatch(setAddons(addOn))

        }
    }
  return (
    <div>
        <OrangeComponent>
            Select additional add ons /  preferences
            </OrangeComponent>

            <FlexParent>
                {
                    currentlySelectedRoom &&
                    currentlySelectedRoom.addOns.map((room)=>{
                        return <ReusableDiv onClick={()=>setAddonHandler(room)}>
                            {room.name}
                        </ReusableDiv>
                    })
                }
            </FlexParent>
               
    </div>
  )
}
