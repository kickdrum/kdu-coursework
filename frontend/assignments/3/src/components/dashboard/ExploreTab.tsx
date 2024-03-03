import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  Box,
  CircularProgress,
  Typography,
  Button,
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
} from "@mui/material";
import { RootState } from "../../redux/store";
import { fetchStocks } from "../../redux/thunks/getStocks";
import { addStock, removeStock } from "../../redux/slices/watchListSlice";
import { Stock } from "../../types/Stock";
import { Link } from "react-router-dom";
import Pagination from "@mui/material/Pagination"; 
import add from "../../assets/add.png";
import added from "../../assets/added.png";
import { createUseStyles } from "react-jss";

const useStyles = createUseStyles({
  company: {
    paddingRight: "600px",
  },
  table: {
    border: "3px solid #000",
    borderRadius: "20px",
    marginTop: "40px",
    paddingBottom: "10px",
  },
  customPagination: {
    "& .MuiPaginationItem-root": {
      border: "2px solid #F8F9FA",
      borderRadius: "50%",
      margin: "0 5px",
      width: "40px",
      height: "40px",
      display: "flex",
      alignItems: "center",
      justifyContent: "center",
      fontWeight: "bold",
      color: "#007bff",
      backgroundColor: "transparent",
    },
    "& .Mui-selected": {
      color: "#007bff",
      backgroundColor: "#E9ECEF",
      border: "2px solid #007bff",
      borderRadius: "50%",
    },
    "& .Mui-disabled": {
      color: "#aaa",
      border: "2px solid #F8F9FA",
    },
  },
});

const ExploreTab: React.FC = () => {
  const dispatch = useDispatch();
  const { stocks, loading, error } = useSelector(
    (state: RootState) => state.explore
  );
  const watchList = useSelector(
    (state: RootState) => state.watchList.watchList
  );
  const [page, setPage] = useState(1);
  const [rowsPerPage, setRowsPerPage] = useState(5);
  const classes = useStyles();

  useEffect(() => {
    dispatch(fetchStocks());
  }, [dispatch]);

  const handleAddToWatchList = (stock: Stock) => {
    dispatch(addStock(stock));
  };

  const handleRemoveFromWatchList = (stockSymbol: string) => {
    dispatch(removeStock(stockSymbol));
  };

  const handleChangePage = (
    event: React.ChangeEvent<unknown>,
    newPage: number
  ) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(1);
  };

  if (loading) {
    return <CircularProgress />;
  }

  if (error) {
    return <Typography variant="body1">Error: {error}</Typography>;
  }

  return (
    <Box>
      <Table>
        <div className={classes.table}>
          <TableHead>
            <TableRow>
              <TableCell className={classes.company}>Company</TableCell>
              <TableCell>Base Price</TableCell>
              <TableCell>Watch List</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {stocks
              .slice((page - 1) * rowsPerPage, page * rowsPerPage)
              .map((stock: Stock, index: number) => (
                <TableRow key={index}>
                  <TableCell>
                    <Link to={`/stock/${stock.stock_symbol}`}>
                      {stock.stock_name}
                    </Link>
                  </TableCell>
                  <TableCell>&#8377;{stock.base_price}</TableCell>
                  <TableCell>
                    {watchList.some(
                      (item) => item.stock_symbol === stock.stock_symbol
                    ) ? (
                      <Button
                        onClick={() =>
                          handleRemoveFromWatchList(stock.stock_symbol)
                        }
                      >
                        <img src={added} alt="Added" />
                      </Button>
                    ) : (
                      <Button onClick={() => handleAddToWatchList(stock)}>
                        <img src={add} alt="Add" />
                      </Button>
                    )}
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
          <Box mt={2} display="flex" justifyContent="center">
            <Pagination
              count={Math.ceil(stocks.length / rowsPerPage)}
              page={page}
              onChange={handleChangePage}
              className={classes.customPagination}
              shape="rounded"
              variant="outlined"
              siblingCount={0}
            />
          </Box>
        </div>
      </Table>
    </Box>
  );
};

export default ExploreTab;
