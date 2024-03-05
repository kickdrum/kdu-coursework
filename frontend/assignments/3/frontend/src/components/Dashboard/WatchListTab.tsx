import { useSelector } from "react-redux";
import StockListContainer from "./StockListContainer";
import { RootState } from "../../redux/store";

function WatchlistTab() {
    const watchlist = useSelector((state: RootState) => state.watchList.watchlistItems);
    const stocks = useSelector((state: RootState) => state.stocks.stocks);
    const watchListStocks = stocks.filter((stock) => watchlist.includes(stock.stock_name));
    return ( 
        <StockListContainer stocks={watchListStocks}/>
     );
}

export default WatchlistTab;