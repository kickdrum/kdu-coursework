import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { useParams } from 'react-router-dom';
import { RootState } from '../redux/store';
import { Stock } from '../types/Stock';
import { updateWallet } from '../redux/slices/walletSlice';
import { addTransaction } from '../redux/slices/transactions';
import {
  Box,
  Typography,
  FormControl,
  Select,
  MenuItem,
  TextField,
  Button,
} from '@mui/material';
import BarGraph from './BarGraph';

const StockDropdown: React.FC = () => {
  const dispatch = useDispatch();
  const { stocks, loading, error } = useSelector((state: RootState) => state.explore);
  const walletBalance = useSelector((state: RootState) => state.wallet.balance);
  const { id } = useParams<{ id: string }>();
  const [selectedStock, setSelectedStock] = useState<string | null>(`${id}`);
  const [basePrice, setBasePrice] = useState<number | null>(null);
  const [quantity, setQuantity] = useState<number>(0);

  const handleStockSelect = (event: React.ChangeEvent<{ value: unknown }>) => {
    const selectedSymbol = event.target.value as string;
    setSelectedStock(selectedSymbol);
    const selectedStock = stocks.find(stock => stock.stock_symbol === selectedSymbol);
    if (selectedStock) {
      setBasePrice(selectedStock.base_price);
    } else {
      setBasePrice(null);
    }
  };

  const handleQuantityChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setQuantity(parseInt(event.target.value) || 0);
  };

  const handleBuy = () => {
    if (basePrice && quantity * basePrice <= walletBalance) {
      dispatch(updateWallet(walletBalance - quantity * basePrice));
      dispatch(addTransaction({
        stock_name: selectedStock || '',
        stock_symbol: selectedStock || '',
        transaction_price: basePrice,
        timestamp: new Date().toISOString(),
        status: 'Buy',
      }));

      // Reset quantity
      setQuantity(0);
    } else {
      alert('Insufficient balance or invalid quantity');
    }
  };

  const handleSell = () => {
      dispatch(updateWallet(walletBalance + quantity * basePrice!));
      dispatch(addTransaction({
        stock_name: selectedStock || '',
        stock_symbol: selectedStock || '',
        transaction_price: basePrice!,
        timestamp: new Date().toISOString(),
        status: 'Sell',
      }));
  };

  useEffect(() => {
    setSelectedStock(`${id}`);
    const selectedStock = stocks.find(stock => stock.stock_symbol === `${id}`);
    if (selectedStock) {
      setBasePrice(selectedStock.base_price);
    } else {
      setBasePrice(null);
    }
  }, [id, stocks]);

  // Function to generate random price between 0 and 500
  const generateRandomPrice = () => {
    return Math.floor(Math.random() * 501); // 0 to 500
  };

  useEffect(() => {
    const interval = setInterval(() => {
      // Update the base price with a random value
      if (basePrice !== null) {
        setBasePrice(generateRandomPrice());
      }
    }, 5000); // Update every 5 seconds

    return () => clearInterval(interval); // Clear interval on component unmount
  }, [basePrice]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <Box display="flex" alignItems="center">
      <FormControl variant="standard" sx={{ minWidth: 120, mr: 2 }}>
        <Select
          value={selectedStock || ''}
          displayEmpty
          onChange={handleStockSelect}
          inputProps={{ 'aria-label': 'Select stock' }}
        >
          <MenuItem value="" disabled>Select Stock</MenuItem>
          {stocks.map((stock: Stock) => (
            <MenuItem key={stock.stock_symbol} value={stock.stock_symbol}>{stock.stock_name}</MenuItem>
          ))}
        </Select>
      </FormControl>
      <Typography variant="body1">{selectedStock && basePrice ? `Base Price: ${basePrice}` : ''}</Typography>
      <TextField
        type="number"
        value={quantity}
        onChange={handleQuantityChange}
        variant="outlined"
        size="small"
        sx={{ marginLeft: 2 }}
      />
      <Button variant="contained" onClick={handleBuy} sx={{ marginLeft: 1 }}>Buy</Button>
      <Button variant="contained" onClick={handleSell} sx={{ marginLeft: 1 }}>Sell</Button>
      <BarGraph basePrice={basePrice} />

    </Box>
    
  );
}

export default StockDropdown;
