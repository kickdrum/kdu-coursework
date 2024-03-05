import {  RootState } from "../../redux/store";
import StockListContainer from "./StockListContainer";
import {useSelector } from "react-redux";

function ExploreTab() {
  const stocks = useSelector((state: RootState) => state.stocks.stocks);
    return (  <StockListContainer stocks={stocks}/>);
}

export default ExploreTab;