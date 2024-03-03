import React from 'react';
import { Box, Typography, List, ListItem, ListItemText, CircularProgress } from '@mui/material';
import { Transaction } from '../types/Transaction';

interface TransactionListProps {
  transactions: Transaction[];
  loading: boolean;
}

const TransactionList: React.FC<TransactionListProps> = ({ transactions, loading }) => {
  return (
    <Box mt={3}>
      <Typography variant="h6">Transaction History</Typography>
      {loading ? (
        <Box display="flex" justifyContent="center" mt={2}>
          <CircularProgress />
        </Box>
      ) : (
        <List>
          {transactions.map((transaction, index) => (
            <ListItem key={index}>
              <ListItemText
                primary={`${transaction.timestamp} - ${transaction.stock_name}`}
                secondary={`Transaction Price: ${transaction.transaction_price}, Status: ${transaction.status}`}
              />
            </ListItem>
          ))}
        </List>
      )}
    </Box>
  );
}

export default TransactionList;
