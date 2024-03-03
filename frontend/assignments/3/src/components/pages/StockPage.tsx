import React from 'react';
import StockDropdown from '../../stock/StockDropdown';
import TransactionHistory from '../../stock/TransactionHistory';

const StockPage: React.FC = () => {
  return (
    <div>
      <h1>Stock Page</h1>
      <StockDropdown />
      <TransactionHistory/>
    </div>
  );
}

export default StockPage;
