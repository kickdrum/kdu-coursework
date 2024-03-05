import { Box, Card, CardContent, Typography} from "@mui/material";

  interface StockCardProps {
    stock_name: string;
    symbol: string;
    buyDate?: string;
    sellDate?: string;
    maxProfit: number;
    buyPrice?: number;
    sellPrice?: number;
  }

function StockCard({buyDate,sellDate,maxProfit,stock_name,buyPrice,sellPrice,symbol}:StockCardProps) {
    return (  
        <Card sx={{backgroundColor: maxProfit > 0 ? "#1971c2": "#e03131",margin:"10px 10px"}}>
            <CardContent sx={{display:"flex",justifyContent:"space-between"}}>
                <Box>
                <Typography variant="h5">{symbol}</Typography>
                <Typography variant="body2">Max Profit: ₹{maxProfit.toFixed(2)}</Typography>
                </Box>
               
        {maxProfit ? (
          <Box>
            <Typography variant="body2">
              Buy ₹ {buyPrice?.toFixed(2)} on {buyDate} 
            </Typography>
            <Typography variant="body2">
              Sell ₹ {sellPrice?.toFixed(2)} on {sellDate}
            </Typography>
            
          </Box>
        ) : (
          <Typography variant="body2">Calculating...</Typography>
        )}
      </CardContent>
            </Card>
    );
}

export default StockCard;