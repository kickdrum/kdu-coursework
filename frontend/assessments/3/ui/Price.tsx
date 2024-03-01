import React from 'react'
import { RootState } from '../redux/Store'
import { useSelector } from 'react-redux'

export  function Price() {
    const currentlySelectedRoom=useSelector((state:RootState)=>state.rooms.currentlySelectedRoom)
    const dates = useSelector((state:RootState)=>state.rooms.dates)
    const addons = useSelector((state:RootState)=>state.rooms.addonsSelected)
    let dayPrice:number=0;
    if(currentlySelectedRoom!=null)
  {   dayPrice = Number(currentlySelectedRoom.costPerNight)*dates+addons.reduce((acc,curr)=>acc+Number(curr.cost),0)
  }

    
  return (
    <div>{Number.isNaN(dayPrice)?0:dayPrice}</div>
  )
}
