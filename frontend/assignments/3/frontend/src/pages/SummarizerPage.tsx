import { CircularProgress, Container } from "@mui/material";
import Navbar from "../components/Navbar";
import { useDispatch, useSelector } from "react-redux";
import { useEffect, useRef, useState } from "react";
import { AppDispatch, RootState } from "../redux/store";
import { getAllStocksTransactions } from "../redux/thunks/GetAllStocksTransaction";
import StockCard from "../components/Summarizer/StockCard";


export interface Summary {
  stock_name: string;
  symbol: string;
  buyDate: string;
  sellDate: string;
  buyPrice: number;
  sellPrice: number;
  maxProfit: number;
}

function SummarizerPage() {
  const [loading, setLoading] = useState(true);
  const [summary, setSummary] = useState<Summary[]>([]);
  const ServiceWorkerRef = useRef<Worker | null>(null);
  const allStocks = useSelector(
    (state: RootState) => state.allStocksTransactions.allStocksTransactions
  );
  const reduxDispatch: AppDispatch = useDispatch();
  useEffect(() => {
    reduxDispatch(getAllStocksTransactions());
  }, [reduxDispatch]);

  useEffect(() => {
    const calculateSummary = async () => {
      try {
        
        ServiceWorkerRef.current = new Worker(
          new URL("/Users/prithvirajb/mini-project-frontend/src/serviceWorker/stockWorker.ts", import.meta.url)
        );
        ServiceWorkerRef.current.postMessage(allStocks);
        ServiceWorkerRef.current.onmessage = (event) => {
          setSummary(event.data);
          setLoading(false);
        };
        ServiceWorkerRef.current.onerror = (error) => {
          console.error(error);
          setLoading(false);
        };
      } catch (error) {
        console.log(error);
        setLoading(false);
      }
    };
    if (allStocks.length > 0 && loading) {
      calculateSummary();
    }
    return () => {
      if (ServiceWorkerRef.current) {
        
        ServiceWorkerRef.current.terminate();
      }
    };
  }, [allStocks, loading]);
  return (
    <>
      <Navbar />
      {loading && <Container sx={{display:"flex",justifyContent:"center",alignContent:"center"}}><CircularProgress /></Container>}
      {summary.map((stockSum, index) => (
        <StockCard
          key={index}
          stock_name={stockSum.stock_name}
          symbol={stockSum.symbol}
          maxProfit={stockSum.maxProfit}
          buyDate={stockSum.buyDate}
          sellDate={stockSum.sellDate}
        />
      ))}
    </>
  );
}

export default SummarizerPage;
