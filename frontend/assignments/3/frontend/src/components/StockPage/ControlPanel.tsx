import { Button, Dropdown, Menu, MenuButton, MenuItem } from "@mui/base";
import { Box, CircularProgress, Link, Typography, styled } from "@mui/material";
import KeyboardArrowDownIcon from "@mui/icons-material/KeyboardArrowDown";
import { useEffect, useState } from "react";
import { Stocks } from "../../types/Stocks";
import { PortfolioStockTransactions, Status } from "../../types/PortfolioTransaction";
import { io } from "socket.io-client";

const styles: { [key: string]: React.CSSProperties } = {
  sell_button: {
    cursor: "pointer",
    marginLeft: "1.5rem",
    width: "5vw",
    fontSize: "1rem",
    color: "#e54b4b",
    backgroundColor: "#ffc9c9",
    border: "1px solid #e54b4b",
  },
  display_price_container: {
    marginLeft: "1.5rem",
    border: "1px solid black",
    display: "flex",
    padding: "0.4rem",
    width: "22vw",
    fontSize: "1.5rem",
    justifyContent: "space-between",
  },
  input_field: {
    height: "100%",
    width: "12vw",
    fontSize: "1rem",
    border: "1px solid black",
    padding: "0.5rem",
    textAlign: "center",
  },
  buy_button: {
    cursor: "pointer",
    marginLeft: "1.2rem",
    width: "5vw",
    fontSize: "1rem",
    color: "#34a148",
    backgroundColor: "#b2f2bb",
    border: "1px solid #34a148 ",
  },
  percentage: {
    fontSize: "0.7rem",
    paddingTop: "1rem",
  },
  currentPrice: {
    fontSize: "1.3rem",
    paddingLeft: "2rem",
  },
  button_container: {
    marginLeft: "1.5rem",
    display: "flex",
  },
};

interface ControlPanelProps {
  id: string | undefined;
  stocks: Stocks[];
}

function ControlPanel({ id, stocks }: ControlPanelProps) {
    const [currentBalance, setCurrentBalance] = useState<number>(1000);
    const [quantity, setQuantity] = useState<string>("");
    const [stock, setStock] = useState<Stocks>();
    const [prices, setPrices] = useState<number[]>([]);
    const [news, setNews] = useState<string[]>([]);

    useEffect(() => {
        const socket = io('http://localhost:7000');
        socket.emit("join",id);

        socket.on("send", (message) => {
            setNews((prevData) => [message, ...prevData]); 
        });

        return () => {
            socket.disconnect();
        };
    }, [id]);
    
    const handleBuyTransaction = () => {
        if (!quantity) {
            alert('Quantity cant be zero')
            return;
        }
        const buyQuantity = parseInt(quantity, 10);
        if (isNaN(buyQuantity) || buyQuantity <= 0) {
            alert("Enter a valid number greater than zero");
            return;
        }
        const buyPrice = buyQuantity * (prices[prices.length - 1] || 0);
        if (buyPrice <= currentBalance) {
            setCurrentBalance(currentBalance - buyPrice);
        } else {
            if (stock) {
                const transaction: PortfolioStockTransactions = {
                    stock_name: stock.stock_name,
                    stock_symbol:stock.stock_symbol,
                    transaction_price: buyPrice,
                    timestamp: new Date().toISOString(),
                    status:Status.Failed,
                }

            }
        }

    }

    const handleSellTransaction = () => {
        
    }

  useEffect(
    () => setStock(stocks.find((stock) => stock.stock_name === id)),
    [stock, id, stocks]
  );
  return (
    <Box sx={{ display: "flex", justifyContent: "space-evenly" ,marginRight:"10px"}}>
      {stock === undefined && <CircularProgress />}
      <Box>
        <Dropdown >
          <MenuButton>
            <Box
              sx={{
                display: "flex",
                alignItems: "center",
                backgroundColor: "#fff",
                padding:"5px 0px"
              }}
            >
              <span>
                <Box
                  sx={{
                    border: "2px solid #FFA500",
                    backgroundColor: "#FFFF00",
                    color: "#FFA500",
                    marginRight: "8px",
                    fontSize: "1.3rem",
                  }}
                >
                  {stock?.stock_symbol}
                </Box>
              </span>
              <Box sx={{ marginRight: "8px", fontSize: "1.3rem" }}>
           
                {stock?.stock_name}
              </Box>

              <span>
                <KeyboardArrowDownIcon />
              </span>
            </Box>
          </MenuButton>
          <Menu slots={{ listbox: Listbox }}>
            {stocks.map((stock) => (
              <MenuItem>
                <Link
                  href={`/stock/${stock.stock_name}`}
                  sx={{ marginBottom: "1rem" }}
                  underline="none"
                >
                  {stock.stock_name}
                </Link>
              </MenuItem>
            ))}
          </Menu>
        </Dropdown>
      </Box>
      <Box style={styles.display_price_container}>
        <Typography sx={{ fontWeight: "500" }}>Price</Typography>
        <Typography style={styles.currentPrice}>142.32</Typography>
        <Box>^</Box>
        <Typography style={styles.percentage}>3.00%</Typography>
      </Box>

      <Box style={styles.button_container}>
        <Box>
          <input type="text" placeholder="Enter QTY" style={styles.input_field} value={quantity} onChange={(e) => setQuantity(e.target.value)}/>
        </Box>
        <Button style={styles.buy_button} onClick={handleBuyTransaction}>BUY</Button>
        <Button style={styles.sell_button} onClick={handleSellTransaction}>SELL</Button>
      </Box>
    </Box>
  );
}
const Listbox = styled("ul")(
  ({ theme }) => `
    font-family: 'IBM Plex Sans', sans-serif;
    font-size: 1rem;
    box-sizing: border-box;
    padding-top: 6px;
    margin: 12px 0;
    max-width: 200px;
    max-height: 100px;
    border-radius: 12px;
    overflow: auto;
    outline: 0px;
    list-style:none;
    border: 1px solid black;
    box-shadow: 0px 4px 6px ${
      theme.palette.mode === "dark" ? "rgba(0,0,0, 0.50)" : "rgba(0,0,0, 0.05)"
    };
    z-index: 1;
    `
);
export default ControlPanel;
