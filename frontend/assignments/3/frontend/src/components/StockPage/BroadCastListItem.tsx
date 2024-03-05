import { ListItem, Box, Typography } from "@mui/material";

interface BroadCastListItemProps{
    stock_name: string,
    quantity:number,
}

function BroadCastListItem({stock_name ,quantity}:BroadCastListItemProps) {
    return ( 
        <ListItem sx={{marginBottom:"3px"}}>
              <Box>
                  <Typography sx={{fontSize:"16px", fontWeight:"500"}}>Sagun bought {quantity} {stock_name}</Typography>
                  <Typography sx={{fontSize:"8px"}}>10:00 AM</Typography>
        </Box>
      </ListItem>
     );
}

export default BroadCastListItem;