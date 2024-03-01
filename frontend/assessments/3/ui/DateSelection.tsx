import React, { useEffect, useState } from 'react'
import { OrangeComponent } from './csshelpers'
import { AppDispatch } from '../redux/Store';
import { useDispatch } from 'react-redux';
import { setDates } from '../redux/HomeSlice';
import { Snackbar } from '@mui/material';

export  function DateSelection() {
  const [startdate, setStartdate] = useState("")
  const [enddate,setEnddate]=useState("")
  const dispatch:AppDispatch=useDispatch();  
  const [showsnackbar,setshowsnackbar]=useState(false)
  
  useEffect(()=>{
    if(startdate>enddate)
    {
      setshowsnackbar(true)
      console.log(showsnackbar)
    }
    else 
    {
      setshowsnackbar(false)
      let end = new Date(enddate)
      let start = new Date(startdate)
      let difference = end.getDate() - start.getDate();

      console.log(difference)
      dispatch(setDates(difference))

    }
  },[startdate,enddate])
  return (
    <div>
      <OrangeComponent>
        Select Date
      </OrangeComponent>
      <input type="date" id="start-date" onChange={(e)=>setStartdate(e.target.value)}/>
      <input type="date" id="end-date" onChange={(e)=>setEnddate(e.target.value)}/>
      {showsnackbar?<div>Start date should be less than end</div>:null}
    </div>
  )
}
