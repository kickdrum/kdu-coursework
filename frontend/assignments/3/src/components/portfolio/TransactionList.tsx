// components/TransactionList.tsx
import React from "react";
import { Box, Typography } from "@mui/material";
import { Transaction } from "../../types/Transaction";
import { createUseStyles } from "react-jss";

const useStyles = createUseStyles({
  item: {
    minWidth: "1000px",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
  },
  content: {
    display: "flex",
    flexDirection: "row",
    width: "100%",
    justifyContent: "space-between",
    padding: "10px",
  },
  hr: {
    width: "100%",

  },
  hr2: {
    width: "100%",
    borderTop: '1px dashed #000',

  },
  dot:{
    // height:"100%",
    display:"flex",
    alignItems:"center"
  },
  text1: {
    minWidth: "250px",
  },
  text2: {
    minWidth: "100px",
  },
});

interface TransactionListProps {
  transactions: Transaction[];
  loading: boolean;
}

const TransactionList: React.FC<TransactionListProps> = ({
  transactions,
  loading,
}) => {
  const classes = useStyles();

  if (loading) {
    return <Box>Loading...</Box>;
  }

  const groupedTransactions = groupTransactionsByDate(transactions);

  return (
    <Box>
      {Object.entries(groupedTransactions).map(([date, transactions]) => (
        <Box key={date} mb={2}>
          <Typography variant="h6">{formatDate(date)}</Typography>
          <hr className={classes.hr2}/>

            {transactions.map((transaction, index) => (
          <div>
              <Box key={index} className={classes.item}>
                {/* Render individual transaction details with time */}
                <div className={classes.content}>
                  <Typography className={classes.text1}>
                    {transaction.stock_name}
                  </Typography>
                  <Typography className={classes.text2}>
                    {transaction.stock_symbol}
                  </Typography>
                  <Typography className={classes.text2}>
                    {transaction.transaction_price}{" "}
                  </Typography>
                  <Typography className={classes.text2}>
                    {getTime(transaction.timestamp)}
                  </Typography>
                </div>
                {/* Render red or green dot based on status  */}
                <Box
                  width={10}
                  height={10}
                  borderRadius="50%"
                  mr={1}
                  className={classes.dot}
                  bgcolor={transaction.status === "Failed" ? "red" : "green"}
                ></Box>
              </Box>
            <hr className={classes.hr} />
          </div>
            ))}
        </Box>
      ))}
    </Box>
  );
};

// Function to group transactions by date
const groupTransactionsByDate = (transactions: Transaction[]) => {
  const groupedTransactions: { [key: string]: Transaction[] } = {};
  transactions.forEach((transaction) => {
    const dateKey = new Date(transaction.timestamp).toLocaleDateString();
    if (!groupedTransactions[dateKey]) {
      groupedTransactions[dateKey] = [];
    }
    groupedTransactions[dateKey].push(transaction);
  });
  return groupedTransactions;
};

// Function to get time from timestamp
const getTime = (time: string): string => {
  const [hours, minutes] = time.split(":").map(Number);
  const period = hours >= 12 ? "PM" : "AM";
  const formattedHours = hours % 12 || 12;
  return `${formattedHours}:${minutes.toString().padStart(2, "0")}${period}`;
};

const formatDate = (dateString: string): string => {
  // Split the date string into day, month, and year
  const [day, month, year] = dateString.split("/").map(Number);

  // Create a new Date object
  const date = new Date(year, month - 1, day);

  // Get the month name from the Date object
  const monthName = date.toLocaleString("en-US", { month: "short" });

  // Get the day of the month
  const formattedDay = date.getDate();

  // Return the formatted date string
  return `${monthName} ${formattedDay} ${year}`;
};

export default TransactionList;
