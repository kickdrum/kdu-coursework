import { Box } from "@mui/material";
export interface BarGraphProps{
    currentPrice: number,
    base:number,
}

function BarGraph({currentPrice,base}:BarGraphProps) {
    return (<Box sx={{ minWidth: "20px",
    maxWidth: "20px",
    height: `${base}px`,
    backgroundColor: currentPrice < base ? "#b2f2bb" : "#ffc9c9",}}></Box>  );
}

export default BarGraph;