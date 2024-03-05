import { Box, Typography } from "@mui/material";
interface HistoryTransactionItemProps{
    quantity: number,
    date: string,
    type:"buy" | "sell",
}

function HistoryTransactionItem({quantity,date,type}:HistoryTransactionItemProps) {
    return (  
        <Box sx={{display:"flex" , justifyContent:"space-between",padding:"8px", borderRadius:"10px",border:"1px solid #000"}}>
            <Box>
                <Typography sx={{ fontWeight: "500" }}>{quantity} stocks</Typography>
                <Typography sx={{fontSize:"8px"}}>{date}</Typography>
            </Box>
            <Box sx={{alignSelf:"center"}}>
                {type === "buy" && <Typography sx={{ color: "#2f9e44" }}>Buy</Typography>}
                {type==="sell" && <Typography sx={{color:"#e03131"}}>Sell</Typography>}
            </Box>
        </Box>
    );
}

export default HistoryTransactionItem;