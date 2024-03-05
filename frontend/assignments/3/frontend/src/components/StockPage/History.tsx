import { Stack, Typography } from "@mui/material";

interface HistoryContainerProps{
    id: string | undefined;
}

function HistoryContainer({id}:HistoryContainerProps) {
    return (
        <Stack sx={{border:"1px solid Black", padding:"8px",height:"300px",marginBottom:"20px",overflow:"auto"}}>
            <Typography>History</Typography>
        <Stack spacing={1}>
               
        </Stack>
        </Stack>
         );
}

export default HistoryContainer;