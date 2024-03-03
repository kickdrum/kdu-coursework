import React from 'react';
import { AppBar, Toolbar, Typography } from '@mui/material';
import { Link } from 'react-router-dom';
import {createUseStyles} from 'react-jss'
import logoMarket from '../../assets/logoMarket.png';

const useStyles = createUseStyles(({
  typography: {
    fontWeight: 'bold', 
    color:"white",
    paddingRight:"20px",
    fontSize:'20px',
    paddingLeft:"10px"
  },
  name:{
    display:"flex",
    flexDirection:"row"
  },
  heading:{
    display:"flex",
    flexDirection:"row",
    justifyContent:"space-between",
    width:"100%"
  },
  left:{
  },
  right:{
    display:"flex",
    flexDirection:"row",
  }
}));

const DashboardHeader: React.FC = () => {
  const classes = useStyles();

  return (

    <AppBar>
      <Toolbar>
      <div className={classes.heading}>
        <div className={classes.left}>
          <Link  to={"/"} ><div className={classes.name}><img src={logoMarket} alt="Logo" /><Typography variant="h6" className={classes.typography}>KDU Stock Market</Typography></div></Link>
        </div>
        <div className={classes.right}>
          <Link  to={"/summerizer"}><Typography variant="h6" className={classes.typography}>Summarizer </Typography></Link>
          <Link  to={"/portfolio"}><Typography variant="h6" className={classes.typography}>My Portfolio </Typography></Link>
        </div>
      </div>
      </Toolbar>
    </AppBar>
  );
}

export default DashboardHeader;
