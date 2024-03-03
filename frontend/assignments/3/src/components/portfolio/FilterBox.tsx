import React, { useState, useEffect } from "react";
import {
  Box,
  TextField,
  Checkbox,
  FormControlLabel,
  Button,
  Grid,
  Typography,
} from "@mui/material";
import { Transaction } from "../../types/Transaction";
import { createUseStyles } from "react-jss";
import SearchIcon from "@mui/icons-material/Search";

interface FilterBoxProps {
  transactions: Transaction[];
  setFilteredTransactions: React.Dispatch<React.SetStateAction<Transaction[]>>;
}

const useStyles = createUseStyles({
  fliterContainer: {
    border: "2px solid #000",
    borderRadius: "20px",
    margin: "0",
    padding: "0",
  },
  top: {
    display: "flex",
    justifyContent: "space-between",
    paddingLeft: "20px",
    paddingRight: "20px",
    paddingTop: "10px",
    paddingBottom: "10px",
  },
  line: {
    width: "100%",
    margin: "0",
  },
  search: {
    paddingLeft: "50px",
      paddingBottom: "10px",
  },
  date: {
    paddingTop: "20px",
    paddingLeft: "20px",
    paddingRight: "20px",
    paddingBottom: "10px",
  },
  passFail: {
    display: "flex",
    flexDirection: "column",
    paddingLeft: "20px",
    paddingRight: "20px",
    paddingTop: "10px",
    paddingBottom: "10px",
  },
  companyList:{
    display:"flex",
    flexDirection:"column",
    justifyContent:"start",
    paddingLeft: "20px",
    paddingRight: "20px",
    paddingTop: "10px",
    paddingBottom: "10px",
  }
});

const FilterBox: React.FC<FilterBoxProps> = ({
  transactions,
  setFilteredTransactions,
}) => {
  const [searchText, setSearchText] = useState<string>("");
  const [showFailed, setShowFailed] = useState<boolean>(true);
  const [showPassed, setShowPassed] = useState<boolean>(true);
  const [startDate, setStartDate] = useState<string>("");
  const [endDate, setEndDate] = useState<string>("");
  const [selectedCompanies, setSelectedCompanies] = useState<string[]>([]);
  const [companyList, setCompanyList] = useState<string[]>([]);

  const classes = useStyles();

  useEffect(() => {
    const companies = Array.from(
      new Set(transactions.map((transaction) => transaction.stock_name))
    );
    setCompanyList(companies);
  }, [transactions]);

  useEffect(() => {
    filterTransactions();
  }, [
    searchText,
    showFailed,
    showPassed,
    startDate,
    endDate,
    selectedCompanies,
  ]);

  const filterTransactions = () => {
    const filteredTransactions = transactions.filter((transaction) => {
      const isMatched =
        transaction.stock_name
          .toLowerCase()
          .includes(searchText.toLowerCase()) ||
        transaction.stock_symbol
          .toLowerCase()
          .includes(searchText.toLowerCase());

      const isWithinDateRange =
        (!startDate ||
          new Date(transaction.timestamp) >= new Date(startDate)) &&
        (!endDate || new Date(transaction.timestamp) <= new Date(endDate));

      const isCompanySelected =
        selectedCompanies.length === 0 ||
        selectedCompanies.includes(transaction.stock_name);

      if (showFailed && showPassed) {
        return isMatched && isWithinDateRange && isCompanySelected;
      } else if (showFailed) {
        return (
          transaction.status === "Failed" &&
          isMatched &&
          isWithinDateRange &&
          isCompanySelected
        );
      } else if (showPassed) {
        return (
          transaction.status === "Passed" &&
          isMatched &&
          isWithinDateRange &&
          isCompanySelected
        );
      } else {
        return false;
      }
    });
    setFilteredTransactions(filteredTransactions);
  };

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchText(event.target.value);
  };

  const handleCheckboxChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, checked } = event.target;
    if (name === "failed") {
      setShowFailed(checked);
    } else if (name === "passed") {
      setShowPassed(checked);
    } else {
      if (checked) {
        setSelectedCompanies((prevSelected) => [...prevSelected, name]);
      } else {
        setSelectedCompanies((prevSelected) =>
          prevSelected.filter((company) => company !== name)
        );
      }
    }
  };

  const handleStartDateChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setStartDate(event.target.value);
  };

  const handleEndDateChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEndDate(event.target.value);
  };

  const handleClearAll = () => {
    setSearchText("");
    setShowFailed(true);
    setShowPassed(true);
    setStartDate("");
    setEndDate("");
    setSelectedCompanies([]);
  };

  return (
    <Box position="sticky" top={0} p={2} className={classes.fliterContainer}>
      <div className={classes.top}>
        <Typography variant="h6">Filters</Typography>
        <Button variant="contained" color="primary" onClick={handleClearAll}>
          Clear All
        </Button>
      </div>
      <hr className={classes.line} />

      <div className={classes.search}>
      <TextField
        label="Search for a stock"
        variant="outlined"
        margin="normal"
        onChange={handleSearchChange}
        value={searchText}
        InputProps={{
          startAdornment: (
            <SearchIcon sx={{ color: "action.active", mr: 1, my: 0.5 }} />
          ),
        }}
      />
      </div>

      <hr className={classes.line} />

      <Grid container spacing={2} className={classes.date}>
        <Grid item xs={6}>
          <TextField
            id="start-date"
            label="Start Date"
            type="date"
            defaultValue=""
            InputLabelProps={{
              shrink: true,
            }}
            fullWidth
            onChange={handleStartDateChange}
            value={startDate}
          />
        </Grid>
        <Grid item xs={6}>
          <TextField
            id="end-date"
            label="End Date"
            type="date"
            defaultValue=""
            InputLabelProps={{
              shrink: true,
            }}
            fullWidth
            onChange={handleEndDateChange}
            value={endDate}
          />
        </Grid>
      </Grid>
      <hr className={classes.line} />

      <div className={classes.passFail}>
        <FormControlLabel
          control={
            <Checkbox
              checked={showPassed}
              onChange={handleCheckboxChange}
              name="passed"
            />
          }
          label="Passed"
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={showFailed}
              onChange={handleCheckboxChange}
              name="failed"
            />
          }
          label="Failed"
        />
      </div>

      <hr className={classes.line} />
      <Box sx={{ maxHeight: 200, overflowY: "auto" }} className={classes.companyList}>
        {companyList.map((company) => (
          <FormControlLabel
            key={company}
            control={
              <Checkbox
                checked={selectedCompanies.includes(company)}
                onChange={handleCheckboxChange}
                name={company}
              />
            }
            label={company}
          />
        ))}
      </Box>
    </Box>
  );
};

export default FilterBox;
