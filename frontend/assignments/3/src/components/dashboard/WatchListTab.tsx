import React, { useState } from "react";
import {
  Box,
  Typography,
  Button,
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
} from "@mui/material";
import { useSelector, useDispatch } from "react-redux";
import { RootState } from "../../redux/store";
import { removeStock } from "../../redux/slices/watchListSlice";
import { Stock } from "../../types/Stock";
import { createUseStyles } from "react-jss";
import Pagination from "@mui/material/Pagination";
import added from "../../assets/added.png";


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

const WatchListTab: React.FC = () => {
  const classes = useStyles();
  const dispatch = useDispatch();
  const watchList: Stock[] = useSelector(
    (state: RootState) => state.watchList.watchList
  );
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(5);

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
    setPage(0);
  };

  return (
    <Box>
      {watchList.length === 0 ? (
        <Typography variant="body1">Your watchlist is empty.</Typography>
      ) : (
        <>
          <Table>
            <div className={classes.table}>
              <TableHead>
                <TableRow>
                  <TableCell className={classes.company}>Company</TableCell>
                  <TableCell>Base Price</TableCell>
                  <TableCell>Action</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {watchList
                  .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                  .map((stock: Stock, index: number) => (
                    <TableRow key={index}>
                      <TableCell>{stock.stock_name}</TableCell>
                      <TableCell>{stock.base_price}</TableCell>
                      <TableCell>
                        <Button
                          onClick={() =>
                            handleRemoveFromWatchList(stock.stock_symbol)
                          }
                        >
                          <img src={added} alt="Added" />
                        </Button>
                      </TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            <Box mt={2} display="flex" justifyContent="center">
              <Pagination
                count={Math.ceil(watchList.length / rowsPerPage)}
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
        </>
      )}
    </Box>
  );
};

export default WatchListTab;
