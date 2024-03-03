// import React from 'react';
// import { Box, Typography, List, ListItem, ListItemText } from '@mui/material';
// import { Transaction } from '../types/Transaction';

// interface LiveNotificationsProps {
//   transactions: TransactionNew[];
// }

// const LiveNotifications: React.FC<LiveNotificationsProps> = ({ transactions }) => {
//   // Filter transactions to only show BUY/SELL actions relevant to the selected stock
//   const relevantTransactions = transactions.filter(transaction => transaction.stock_name === selectedStock);

//   return (
//     <Box mt={3}>
//       <Typography variant="h6">Live Notifications</Typography>
//       <List>
//         {relevantTransactions.map((transaction, index) => (
//           <ListItem key={index}>
//             <ListItemText
//               primary={`${transaction.timestamp} - ${transaction.status}`}
//               secondary={`Transaction Price: ${transaction.transaction_price}`}
//             />
//           </ListItem>
//         ))}
//       </List>
//     </Box>
//   );
// }

// export default LiveNotifications;
