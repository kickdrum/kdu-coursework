import {
  Box,
  Button,
  Checkbox,
  FormControlLabel,
  FormGroup,
  Stack,
  TextField,
  Typography,
} from "@mui/material";
import { AppDispatch } from "../../redux/store";
import { useDispatch } from "react-redux";
import { clearAll } from "../../redux/slice/FitlerSlice";
import React from "react";
import dayjs, { Dayjs } from "dayjs";
import { DemoContainer } from "@mui/x-date-pickers/internals/demo";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { StockName } from "../../types/PortfolioTransaction";

function FilterBoard() {
  const reduxDispatch: AppDispatch = useDispatch();
  const [beginDate, setBeginDate] = React.useState<Dayjs | null>(dayjs("2024-03-03"));
  const [endDate, setEndDate] = React.useState<Dayjs | null>(dayjs("2024-03-03"));

  const handleclearAll = () => {
    reduxDispatch(clearAll());
  };

  return (
    <Stack
      sx={{
        border: "3px solid #82868a",
        borderRadius: "20px",
        width: "30%",
        marginTop: "30px",
      }}
    >
      <div>
        <span>Filters</span>
       <Button variant="text" onClick={handleclearAll}>clear All</Button>
      </div>
    </Stack>
  );
}

export default FilterBoard;
