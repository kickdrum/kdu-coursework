import { Box, CircularProgress, Pagination, Stack, Typography, useMediaQuery } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Stocks } from "../../types/Stocks";
import StockItem from "./StockItem";

import { RootState } from "../../redux/store";
import { useSelector } from "react-redux";
interface StockListContainerProps{
  stocks: Stocks[]  ;
}

function StockListContainer({ stocks }: StockListContainerProps) {
  const isSmallScreen = useMediaQuery((theme) => theme.breakpoints.down("sm"));
  const [currentPage, setCurrentPage] = React.useState(1);
  const loadingState = useSelector((state: RootState) => state.stocks.state);
  const nPages = Math.ceil(stocks.length / 7);
  const [currentRecord, setCurrentRecord] = React.useState<Stocks[]>([]);
  const [indexOfLastRecord, setIndexOfLastRecord] = React.useState(7);
  const [indexOfFirstRecord, setIndexOfFirstRecord] = React.useState(0);
  const [sortedStocks, setSortedStocks] = useState<Stocks[]>([]);

  useEffect(() => {
    setSortedStocks(stocks.slice().sort((a, b) => a.stock_name.localeCompare(b.stock_name)));
  }, [stocks]);

  useEffect(() => (
    
    setCurrentRecord(sortedStocks.slice(indexOfFirstRecord, indexOfLastRecord))
  ), [currentPage,stocks,indexOfFirstRecord,indexOfLastRecord,sortedStocks]);

  const handleChange = (event: React.ChangeEvent<unknown>, value: number) => {
    setCurrentPage(value);
    setIndexOfLastRecord(value * 7);
    setIndexOfFirstRecord((value * 7)-7);
  };
  return (
    <Stack sx={{ border: "3px solid #82868a", borderRadius: "20px" }}>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          padding:isSmallScreen ?  "10px 35px" : "10px 60px",
          borderBottom: "3px solid #82868a",
        }}
      >
        <Typography sx={{ color: "#343a40" ,  width: 300, fontSize: isSmallScreen ? 12 : 16,}}>Company</Typography>
        <Box
          sx={{ display: "flex", justifyContent: "space-between", gap: "20px" ,width:isSmallScreen ? 290 : 200,}}
        >
          <Typography sx={{ color: "#343a40" ,fontSize: isSmallScreen ? 12 : 16,textWrap:"none"}}>Base Price</Typography>
          <Typography sx={{ color: "#343a40",fontSize: isSmallScreen ? 12 : 16, }}>Watchlist</Typography>
        </Box>
      </Box>
      <Box>
        <Box sx={{padding:isSmallScreen ?  "0px 5px" : "0px 30px"}}>
          {loadingState=="pending" &&    <Box sx={{ display: 'flex' , justifyContent:"center", alignItems:"center"}}>
      <CircularProgress />
    </Box>}
          {currentRecord.map((stock) => (
    
           <StockItem stock={stock} />

   
         ))}
        </Box>
      </Box>
      
      <Box sx={{ width: "100%", display: "flex", justifyContent: "center" }}>
        <Pagination
          count={nPages}
          page={currentPage}
          onChange={handleChange}
          siblingCount={1}
          color="primary"
          sx={{
            "& .MuiPaginationItem-root": {
              color: "#1971c2",
              marginTop: "10px",
              marginBottom: "10px",
            },
            "& .MuiPaginationItem-page.Mui-selected": {
              color: "#1971c2",
              border: "1px solid #1971c2",
              backgroundColor: "#e9ecef",
              "&:hover": {
                backgroundColor:"#1971c2",
                color: "#d9e0e4", 
              },
            },
            "& .MuiPaginationItem-icon": {
              color: "#1971c2",
            },
          }}
        />
      </Box>
    </Stack>
  );
}

export default StockListContainer;
