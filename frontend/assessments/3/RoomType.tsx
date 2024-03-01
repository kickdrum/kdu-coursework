import { AppDispatch,RootState } from '../redux/Store'
import { useDispatch, useSelector } from 'react-redux'
import { useEffect, useState } from 'react'
import { RoomType } from '../interface/RoomInterface'
import { FlexParent, OrangeComponent, ReusableDiv } from './csshelpers';
import { setCurrentlySelectedRoom } from '../redux/HomeSlice';
export  function Room() {
    const dispatch:AppDispatch=useDispatch();
    const isLoading = useSelector((state:RootState)=>state.rooms.loading)
    const roomItems=useSelector((state:RootState)=>state.rooms.roomItems)
    const [roomTypes,setRoomTypes]  = useState<RoomType[]>([])
    useEffect(()=>{
        console.log("roomtypes2",roomItems)
      setRoomTypes(roomItems)
    },[isLoading])

    const [isClicked, setIsClicked] = useState(false);

// useEffect(()=>{
//     const roomTypes2 = useSelector((state:RootState)=>state.rooms.roomItems)
//     setRoomTypes(roomTypes2)

// },[isLoading])
const [selectedItemIndex, setSelectedItemIndex] = useState<number | null>(null);

const selectCurrentRoom = (room: RoomType, index: number) => {
    console.log(room);
    dispatch(setCurrentlySelectedRoom(room));

    setSelectedItemIndex(index);
};
console.log("roomtypes",roomTypes)

  return (
    
    <div>
        <OrangeComponent >
            <h1>Select Room Type</h1>
        </OrangeComponent>
        {isLoading??<p>Loading</p>}
        <div className='room'>
            <FlexParent>
       {
        roomTypes.map((room,index)=>{
           return <ReusableDiv style={{ border: selectedItemIndex === index ? '1px solid orange' : '1px solid black' }} onClick={() => selectCurrentRoom(room, index)}>

                <p onClick={()=>selectCurrentRoom(room,index)}>{room.name}</p>
            </ReusableDiv>
        })
       }
       </FlexParent>
       </div>
        {/* {
            roomTypes.map((room)=>{
                return <div>
                    <p>{room.name}</p>
                    <p>{room.costPerNight}</p>
                </div>
            })
        } */}
        
        
        
        
    </div>
  )
}
