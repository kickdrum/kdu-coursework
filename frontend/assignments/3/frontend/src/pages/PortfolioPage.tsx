import { Box, Button } from "@mui/material";
import Navbar from "../components/Navbar";
import { getPortfolioTransactions } from "../redux/thunks/GetPortfolioTransaction";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/store";
import { PortfolioStockTransactions } from "../types/PortfolioTransaction";
import CircleIcon from '@mui/icons-material/Circle';

interface DateGroupedTransactions {
  [date: string]: PortfolioStockTransactions[];
}
const styles: { [key: string]: React.CSSProperties } = {
  mainContainer:{
    display:"flex",
    width:"90vw",
    height:"80vh",
    marginLeft:"5rem",
    flexWrap:"wrap",
    marginTop:"1rem",
  },
  transactionsContainer:{
    margin:"0.5rem",
    minWidth:"65vw",
    height:"75vh",
    overflowY: "auto",
  },
  filterBox:{
    margin:"0.5rem",
    minWidth:"22vw",
    maxWidth:"auto",
    alignSelf:"center",
    height:"50vh",
    display:"flex",
    flex:"1",
    flexDirection:"column",
    border:"2px solid #000",
    borderRadius:"15px",
    backgroundColor:"#e9ecef"
  },
  filterHeader:{
    display:"flex",
    justifyContent:"space-between",
    padding:"1rem",
    borderBottom:"2px solid #6f7072",
    fontSize:"1.5rem",
    fontWeight:"500",
  },
  searchBox:{
    display:"flex",
    justifyContent:"center",
    marginTop:"0.5rem",
    padding:"0.7rem",
    borderBottom:"2px solid #6f7072",
  },
  "& input":{
    height:"3.5vh",
    width:"20vw",
    borderRadius:"10px",
    border:"2px solid #6f7072",
    fontSize:"1rem",
    display:"flex",
    flex:"1",
  },
  dateContainer:{
    display:"flex",
    justifyContent:"space-between",
    borderBottom:"2px solid #6f7072",
  },
  dateInput:{
    margin:"1rem",
    padding:"0.2rem",
    width:"8vw",
    height:"4vh",
    borderRadius:"10px",
    border:"2px solid #6f7072",
    display:"flex",
    flex:"1",
  },
  checkBoxContainer:{
    display:"flex",
    flexDirection:"column",
    padding:"1rem",
    borderBottom:"2px solid #6f7072",
  },
  stocksLabelContainer:{
    display:"flex",
    flexDirection:"column",
    overflowY:"auto",
    padding:"1rem",
  },
  transactionContainer:{
    display:"flex",
    borderBottom:"1px solid #000",
    margin:"1rem",
    padding:"1rem",
    justifyContent:"space-between",
  },
  dateGroup: {
    marginBottom: "0.5rem",
    marginTop:"2rem",
    fontSize: "1rem",
    fontWeight: "bold",
    borderBottom:"2px dotted #a5a6a7",
    padding:"1rem",
    color:"#a5a6a7",
  },
  list_transaction:{
    paddingLeft:"0",
  },
}

function PorfolioPage() {
  const reduxDispatch: AppDispatch = useDispatch();
  const portfolioTransactions = useSelector(
    (state: RootState) =>
      state.portfolioStockTransactions.allPortfolioStocksTransactions
  );
  const [textFilter, setTextFilter] = useState<string>("");
  const [beginDate, setBeginDate] = useState<string>("");
  const [endDate, setEndDate] = useState<string>("");
  const [passedFilter, setPassedFilter] = useState<boolean>(false);
  const [failedFilter, setFailedFilter] = useState<boolean>(false);
  const [selectedStocks, setSelectedStocks] = useState<string[]>([]);

  const clearAllFilters = () => {
    setTextFilter("");
    setBeginDate("");
    setEndDate("");
    setPassedFilter(false);
    setFailedFilter(false);
    setSelectedStocks([]);
  };

  const groupTransactionsByDate = (
    transactions: PortfolioStockTransactions[]
  ) => {
    const groupTransactions: DateGroupedTransactions = {};
    transactions.forEach((transaction) => {
      const dateKey = new Date(transaction.timestamp).toLocaleDateString(
        "en-US",
        {
          day: "2-digit",
          month: "short",
          year: "numeric",
        }
      );
      if (!groupTransactions[dateKey]) {
        groupTransactions[dateKey] = [];
      }
      groupTransactions[dateKey].push(transaction);
    });
    return groupTransactions;
  };
  useEffect(() => {
    reduxDispatch(getPortfolioTransactions());
  }, [reduxDispatch]);

  const filterTransactions = () => {
    const filteredTransaction = portfolioTransactions
      .filter((transaction) => {
        if (passedFilter && transaction.status !== "Passed") {
          return false;
        }
        if (failedFilter && transaction.status !== "Failed") {
          return false;
        }
        return true;
      })
      .filter((transaction) => {
        if (endDate) {
          return new Date(transaction.timestamp) <= new Date(endDate);
        }
        return true;
      })
      .filter((transaction) => {
        if (beginDate) {
          return new Date(transaction.timestamp) <= new Date(beginDate);
        }
        return true;
      })
      .filter((transaction) => {
        return (
          transaction.stock_name
            .toLowerCase()
            .includes(textFilter.toLowerCase()) ||
          transaction.stock_symbol
            .toLowerCase()
            .includes(textFilter.toLowerCase())
        );
      });

    return filteredTransaction;
  };
  const handleStockFilterChange = (stockName: string) => {
    if (selectedStocks.includes(stockName)) {
      setSelectedStocks(selectedStocks.filter((stock) => stock !== stockName));
    } else {
      setSelectedStocks([...selectedStocks, stockName]);
    }
  };
  const groupedStocks = Array.from(
    new Set(portfolioTransactions.map((transaction) => transaction.stock_name))
  );
  const filteredTransactions = filterTransactions();
const groupedTransactions = groupTransactionsByDate(filteredTransactions);
  return (
    <>
      <Navbar />

      <Box style={styles.mainContainer}>
        <Box style={styles.filterBox}>
          <Box style={styles.filterHeader}>
            <span>Filters</span>
            <Button variant="text" onClick={clearAllFilters}>
              Clear All
            </Button>
          </Box>
          <Box style={styles.searchBox}>
            <input
              type="text"
              placeholder="Search For a Stock"
              value={textFilter}
              onChange={(e) => setTextFilter(e.target.value)}
            />
          </Box>
          <Box style={styles.dateContainer}>
            <input
              type="date"
              placeholder="Start Date"
              style={styles.dateInput}
              value={beginDate}
              onChange={(e) => setBeginDate(e.target.value)}
            />
            <input
              type="date"
              placeholder="End Date"
              style={styles.dateInput}
              value={endDate}
              onChange={(e) => setEndDate(e.target.value)}
            />
          </Box>
          <Box style={styles.checkBoxContainer}>
            <label style={{ marginBottom: "0.3rem" }}>
              <input
                type="checkbox"
                checked={passedFilter}
                onChange={() => setPassedFilter(!passedFilter)}
                style={{ marginRight: "1rem" }}
              />
              Passed
            </label>
            <label style={{ marginBottom: "0.3rem" }}>
              <input
                type="checkbox"
                checked={failedFilter}
                onChange={() => setFailedFilter(!failedFilter)}
                style={{ marginRight: "1rem" }}
              />
              Failed
            </label>
          </Box>
          <Box style={styles.stocksLabelContainer}>
            {groupedStocks.map((stockName) => (
              <label key={stockName}>
                <input
                  type="checkbox"
                  checked={selectedStocks.includes(stockName)}
                  onChange={() => handleStockFilterChange(stockName)}
                />
                {stockName}
              </label>
            ))}
          </Box>
        </Box>
        <Box style={styles.transactionsContainer}>
          {Object.entries(groupedTransactions).map(
            ([date, transactions], index) => (
              <Box key={index}>
                <Box style={styles.dateGroup}>{date}</Box>
                <ul style={styles.list_transaction}>
                  {transactions.map((transaction  ) => (
                    <li
                      key={transaction.timestamp}
                      style={styles.transactionContainer}
                    >
                      <Box style={{ width: "25vw" }}>
                        {transaction.stock_name}
                      </Box>
                      <Box>{transaction.stock_symbol}</Box>
                      <Box>
                        {"\u20B9"}
                        {transaction.transaction_price}
                      </Box>
                      <Box>
                        {new Date(transaction.timestamp)
                          .toLocaleString("en-US", {
                            hour: "numeric",
                            minute: "2-digit",
                            hour12: true,
                            timeZone: "UTC",
                          })
                          .replace(",", "")}
                      </Box>
                      <Box>
                        {
                          <CircleIcon
                            style={{
                              color:
                                transaction.status === "Passed"
                                  ? "#6bb97a"
                                  : "#e76d6d",
                            }}
                          />
                          
                        }
                      </Box>
                    </li>
                  ))}
                </ul>
              </Box>
            )
          )}
        </Box>
      </Box>
    </>
  );
}

export default PorfolioPage;
