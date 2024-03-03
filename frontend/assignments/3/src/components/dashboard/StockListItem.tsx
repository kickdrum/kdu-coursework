import React from 'react';
import { ListItem, ListItemText, ListItemSecondaryAction, IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

interface Props {
  stock: {
    stock_name: string;
    stock_symbol: string;
    base_price: number;
  };
  onRemove: () => void;
}

const StockListItem: React.FC<Props> = ({ stock, onRemove }) => {
  return (
    <ListItem>
      <ListItemText primary={stock.stock_name} secondary={stock.stock_symbol} />
      <ListItemSecondaryAction>
        <IconButton edge="end" aria-label="delete" onClick={onRemove}>
          <DeleteIcon />
        </IconButton>
      </ListItemSecondaryAction>
    </ListItem>
  );
}

export default StockListItem;
