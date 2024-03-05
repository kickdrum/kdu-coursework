import { useParams } from "react-router-dom";
import Navbar from "../components/Navbar";
import HistoryContainer from "../components/StockPage/History";
import { Box} from "@mui/material";
import LiveBroadBastBox from "../components/StockPage/LiveBroadCastBox.tsx";
import ControlPanel from "../components/StockPage/ControlPanel.tsx";
import Graph from "../components/StockPage/Graph.tsx";
import { useSelector } from "react-redux";
import { RootState } from "../redux/store.ts";
import { useEffect, useState } from "react";
import { Stocks } from "../types/Stocks.ts";

function StockPage() {
  const { id } = useParams();
  const stocks = useSelector((state: RootState) => state.stocks.stocks);
  const [stock, setStock] = useState<Stocks>();
  const [graphBarValues, setGraphBarValues] = useState<number[]>([]);
  const intervalRef = useRef(null);

  useEffect(() => {
    intervalRef.current = setInterval(() => {
      // Generate a random number within your desired range
      const newValue = Math.floor(Math.random() * 100); // Replace 100 with your desired max value

      // Use the spread operator (...) to create a new array with the updated values
      setGraphBarValues([...graphBarValues, newValue]);
    }, 5000); // Interval set to 5 seconds (5000 milliseconds)

    // Cleanup function to clear the interval when the component unmounts
    return () => clearInterval(intervalRef.current);
  }, []);
  useEffect(
    () => setStock(stocks.find((stock) => stock.stock_name === id)),
    [stock, id, stocks]
  );
  return (
    <>
      <Navbar />
      <Box sx={{display:"flex" , marginTop:"10px"}}>
        <Box sx={{ width: "75%" }}>
          {stock && <>
            <ControlPanel stocks={stocks} id={id} />
            <Box sx={{ position: "relative", }}>
              <Graph base={stock?.base_price} barGaphValues={[]} />
            </Box>
          </>
          }
      </Box>
      <Box sx={{width:"25%"}}>
        <HistoryContainer id={id} />
        <LiveBroadBastBox id={id}/>
      </Box>
      </Box>
      
   
    </>
  );
}

export default StockPage;
