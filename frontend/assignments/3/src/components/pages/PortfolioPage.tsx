import React, { useState, useEffect } from "react";
import { Box } from "@mui/material";
import FilterBox from "../portfolio/FilterBox";
import TransactionList from "../portfolio/TransactionList";
import { Transaction } from "../../types/Transaction";
import { createUseStyles } from "react-jss";

const useStyles = createUseStyles({
  content: {
    marginLeft: "60px",
    display: "flex",
    position: 'sticky',
    width:"100%"
  },
  all:{
    paddingTop:"100px"
  },
  list:{
    paddingLeft:"100px",
    // width:"100%"
  }
});

const PortfolioPage: React.FC = () => {
  const [transactions, setTransactions] = useState<Transaction[]>([]);
  const [filteredTransactions, setFilteredTransactions] = useState<
    Transaction[]
  >([]);
  const [loading, setLoading] = useState<boolean>(false);
  const classes = useStyles();

  useEffect(() => {
    const fetchTransactions = async () => {
      setLoading(true);
      try {
        const response = await fetch(
          "https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/portfolio-transactions.json"
        );
        const data = await response.json();
        setTransactions(data.reverse());
        setFilteredTransactions(data.reverse());
      } catch (error) {
        console.error("Error fetching transactions:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchTransactions();
  }, []);

  return (
    <div className={classes.all}>
    <Box className={classes.content}>
      <div>
        <FilterBox
          transactions={transactions}
          setFilteredTransactions={setFilteredTransactions}
        />
      </div>
      <div className={classes.list}>
        <TransactionList transactions={filteredTransactions} loading={loading} />
      </div>
    </Box>
    </div>
  );
};

export default PortfolioPage;
