import {
  Box,
  IconButton,
  Typography,
  useMediaQuery,
  Popover,
  Link,
} from "@mui/material";
import * as React from "react";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";
import { Stocks } from "../../types/Stocks";
import CheckCircleIcon from "@mui/icons-material/CheckCircle";
import CancelIcon from "@mui/icons-material/Cancel";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../../redux/store";
import {
  addItemToWatchList,
  removeItemFromWatchList,
} from "../../redux/slice/WatchListSlice";

interface StockItemProps {
  stock: Stocks;
}

function StockItem({ stock }: StockItemProps) {
  const isSmallScreen = useMediaQuery((theme) => theme.breakpoints.down("sm"));
  const watchlist = useSelector(
    (state: RootState) => state.watchList.watchlistItems
  );
  const reduxDispatch: AppDispatch = useDispatch();
  const isInWatchlist = watchlist.includes(stock.stock_name);

  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

  const handleAddToWatchList = () => {
    reduxDispatch(addItemToWatchList(stock.stock_name));
  };

  const handleRemoveWatchList = () => {
    reduxDispatch(removeItemFromWatchList(stock.stock_name));
  };

  const handlePopoverOpen = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handlePopoverClose = () => {
    setAnchorEl(null);
  };

  const open = Boolean(anchorEl);
  const id = open ? "simple-popover" : undefined;

  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "space-between",
        padding: "10px 30px",
        borderBottom: "1px solid #82868a",
      }}
    >
      <Typography
        sx={{
          color: "#343a40",
          width: 300,
          whiteSpace: "nowrap",
          overflow: "hidden",
          textOverflow: "ellipsis",
          fontSize: isSmallScreen ? 11 : 16,
        }}
      >
        <Link href={`/stock/${stock.stock_name}`} underline="none">
          {stock.stock_name}
        </Link>
      </Typography>
      <Box
        sx={{
          display: "flex",
          justifyContent: "space-between",
          gap: "20px",
          width: isSmallScreen ? 290 : 200,
        }}
      >
        <Typography
          sx={{
            color: "#343a40",
            textAlign: "center",
            paddingLeft: "10px",
            fontSize: isSmallScreen ? 11 : 16,
          }}
        >
          {stock.base_price}
        </Typography>
        <IconButton
          onClick={isInWatchlist ? handleRemoveWatchList : handleAddToWatchList}
          onMouseEnter={handlePopoverOpen}
          onMouseLeave={handlePopoverClose}
          sx={{
            fontSize: isSmallScreen ? 11 : 16,
            padding: "0px 20px 0px 0px",
          }}
        >
          {isInWatchlist ? (
            <CheckCircleIcon color="primary" />
          ) : (
            <AddCircleOutlineIcon color="primary" />
          )}
          <Popover
            id={id}
            open={open}
            anchorEl={anchorEl}
            onClose={handlePopoverClose}
            onClick={handleRemoveWatchList}
            anchorOrigin={{
              vertical: "bottom",
              horizontal: "center",
            }}
            transformOrigin={{
              vertical: "top",
              horizontal: "center",
            }}
          >
            <CancelIcon color="error" />
          </Popover>
        </IconButton>
      </Box>
    </Box>
  );
}

export default StockItem;
