import { Link } from "react-router-dom";
import Logo from "../assets/stock_market_logo.png";
import {
  AppBar,
  Box,
  Button,
  Collapse,
  List,
  ListItemButton,
  ListItemText,
  Toolbar,
  Typography,
  useMediaQuery,
} from "@mui/material";
import { useState } from "react";

import MenuIcon from "@mui/icons-material/Menu";

const styles: { [key: string]: React.CSSProperties } = {
  image: {
    width: "40px",
    height: "40px",
    objectFit: "contain",
  },
};

function Navbar() {
  const small = useMediaQuery("(max-width:414px)");
  const full = useMediaQuery("(min-width:415px)");

  const [open, setOpen] = useState(false);
  const handleClick = () => {
    setOpen(!open);
  };
  return (
    <AppBar position="static" >
      <Toolbar
        variant="dense"
        sx={{ display: "flex", justifyContent: "space-between" }}
      >
        {small && (
          <List>
            <ListItemButton sx={{ paddingLeft: "5px" }}>
              <Button onClick={handleClick} sx={{ paddingLeft: "5px" }}>
                <MenuIcon sx={{ color: "white" }} />
              </Button>

              <Link to="/">
                <Box>
                  <img src={Logo} alt="logo-image" style={styles.image} />
                </Box>
              </Link>
              <Typography
                variant="h5"
                color="inherit"
                fontSize="large"
                noWrap={true}
                sx={{ color: "white" }}
              >
                KDU Stock Market
              </Typography>
            </ListItemButton>
            <Collapse in={open} timeout="auto" unmountOnExit>
              <List component="div" disablePadding>
                <ListItemButton>
                  <Link to="/summarizer">
                    <ListItemText primary="Summarizer"  sx={{ color: "#f5f5f5" }}/>
                  </Link>
                </ListItemButton>
                <ListItemButton>
                  <Link to="/portfolio">
                    <ListItemText primary="My Portfolio" sx={{ color: "#f5f5f5" }}/>
                  </Link>
                </ListItemButton>
              </List>
            </Collapse>
          </List>
        )}
        {full && (
          <>
            <Link to="/">
              <Box sx={{ width: "300px", height: "40px", display: "flex" }}>
                <img src={Logo} alt="Logo-image" style={styles.image} />
                <Typography
                  variant="h3"
                  color="inherit"
                  noWrap={true}
                  sx={{ alignSelf: "center", color: "white" }}
                >
                  KDU Stock Market
                </Typography>
              </Box>
            </Link>

            <Box component="nav">
              <Link to="/summarizer">
                <Button sx={{ color: "white" }}>
                  <Typography variant="h4" color="inherit" noWrap={true}>
                    Summarizer
                  </Typography>
                </Button>
              </Link>
              <Link to="/portfolio">
                <Button sx={{ color: "white" }}>
                  <Typography variant="h4" color="inherit" noWrap={true}>
                    My Portfolio
                  </Typography>
                </Button>
              </Link>
            </Box>
          </>
        )}
      </Toolbar>
    </AppBar>
  );
}

export default Navbar;
