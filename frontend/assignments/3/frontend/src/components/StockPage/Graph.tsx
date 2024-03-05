import { Box } from "@mui/material";
import BarGraph from "./BarGraph";
interface GraphProps{
  base: number;
  barGaphValues: number[];
}

function Graph({base,barGaphValues}:GraphProps) {
    return ( 
            <Box className="graph-grid">
              <Box className="col">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row last-box"></Box>
              </Box>
              <Box className="col">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row last-box"></Box>
              </Box>
              <Box className="col">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row last-box"></Box>
              </Box>
              <Box className="col last-box">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row last-box"></Box>
              </Box>
              <Box className="col">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
              </Box>
              <Box className="col last-box">
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row"></Box>
                <Box className="row last-box"></Box>
        </Box>
        <Box className="graph-bars"></Box>
        {
          barGaphValues.map((value) => (
            <BarGraph currentPrice={value} base={base} />
          ))
        }
     
            </Box>
            
     
     );
}

export default Graph;