import React from 'react';
import { useSelector } from 'react-redux';
import { RootState } from '../redux/store';
import { Transaction } from '../types/Transaction';
import { Box, Typography } from '@mui/material';

const TransactionHistory: React.FC = () => {
  const transactions = useSelector((state: RootState) => state.transactions.transactions);

  return (
    <Box sx={{ width: '100%', maxHeight: 200, overflowY: 'auto', marginTop: 2 }}>
      <Typography variant="h6">Transaction History</Typography>
      {transactions.map((transaction: Transaction, index: number) => (
        <Box key={index} sx={{ marginTop: 1 }}>
          <Typography variant="body1">{`${transaction.timestamp}: ${transaction.status} - ${transaction.stock_name} (${transaction.stock_symbol}) at ${transaction.transaction_price}`}</Typography>
        </Box>
      ))}
    </Box>
  );
}

export default TransactionHistory;
