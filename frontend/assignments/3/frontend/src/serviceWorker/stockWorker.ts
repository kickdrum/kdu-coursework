import { Summary } from "../pages/SummarizerPage";
import { Datum } from "../types/AllStocksTransaction";

interface StockWorkerProps {
  stock_name: string;
  symbol: string;
  data: Datum[];
}

function calculateBestBuySell({
  stock_name,
  symbol,
  data,
}: StockWorkerProps): Summary {
  console.log("cal");
  let maxProfit = 0;
  let buyDate = "";
  let sellDate = "";
  let minPrice = Infinity;
  let buyPrice = 100;
  let sellPrice = 200;

  for (let i = 0; i < data.length; i++) {
    const currentPrice = data[i].prices[0];
    let maxProfitForDay = 0;
    for (let j = i + 1; j < data.length; j++) {
      const profit = data[j].prices[0] - currentPrice;
      if (profit > maxProfitForDay) {
        maxProfitForDay = profit;
      }
      if (maxProfitForDay > maxProfit) {
        // sellDate = data[j - 1].date.toISOString();
        break;
      }
    }
    minPrice = Math.min(minPrice, currentPrice);
    if (maxProfitForDay > maxProfit) {
      maxProfit = maxProfitForDay;
      // buyDate = data[i].date.toISOString();
      console.log(maxProfit);
    }
  }
  return {
    stock_name,
    symbol,
    buyDate,
    sellDate,
    maxProfit,
    buyPrice,
    sellPrice,
  };
}

onmessage = function (e: MessageEvent<StockWorkerProps[]>) {
  const stocks: StockWorkerProps[] = e.data;
  const results: Summary[] = [];

  stocks.forEach((stock) => {
    const { stock_name, symbol, data } = stock;
    const result = calculateBestBuySell({ stock_name, symbol, data });

    results.push(result);
  });

  postMessage(results);
};
