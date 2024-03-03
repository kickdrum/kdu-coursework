import React, { useState, useEffect } from 'react';
import { Box } from '@mui/material';

interface BarGraphProps {
  basePrice: number | null;
}

const BarGraph: React.FC<BarGraphProps> = ({ basePrice }) => {
  const [priceChanges, setPriceChanges] = useState<{ value: number; color: string }[]>([]);
  const [previousPrice, setPreviousPrice] = useState<number | null>(null);

  // Append new price changes every 5 seconds
  useEffect(() => {
    const interval = setInterval(() => {
      if (basePrice !== null) {
        const newPrice = basePrice; // Use the base price passed from props
        const color = previousPrice !== null && newPrice < previousPrice ? 'red' : 'green'; // Determine color based on price change
        setPriceChanges(prevChanges => [...prevChanges, { value: newPrice, color }]);
        setPreviousPrice(newPrice); // Update previous price
      }
    }, 5000);

    return () => clearInterval(interval);
  }, [basePrice]); // Run effect when basePrice changes

  return (
    <Box
      sx={{
        width: '500px',
        height: '500px',
        position: 'relative',
        overflow: 'hidden',
        background: '#f0f0f0',
        boxSizing: 'border-box',
        display: 'flex',
        flexDirection: 'row-reverse', // Align bars from right to left
        justifyContent: 'flex-end', // Push bars to the right
      }}
    >
      {priceChanges.map((change, index) => (
        <Box
          key={index}
          sx={{
            flexShrink: 0,
            width: '20px', // Fixed width for each bar
            height: `${change.value}px`, // Height equal to the new value of base price
            backgroundColor: change.color,
            border: '1px solid black',
            marginTop: 'auto', // Align bars to the bottom
          }}
        />
      ))}
    </Box>
  );
};

export default BarGraph;
