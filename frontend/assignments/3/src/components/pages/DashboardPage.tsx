import React from 'react';
import { Container, Tabs, Tab } from '@mui/material';
import ExploreTab from '../dashboard/ExploreTab';
import WatchListTab from '../dashboard/WatchListTab'; 
import {createUseStyles} from 'react-jss'

const useStyles = createUseStyles(({
  top:{
    width:"100%",
    maxWidth: '100%',
    paddingTop:"100px",

  },
  bottom:{
    display:"flex",
    justifyContent:"center",
  },
  all:{
    display:"flex",
    justifyContent:"center",
    width:"100%"
  }
  
}));

const DashboardPage: React.FC = () => {
  const classes=useStyles();
  const [tabIndex, setTabIndex] = React.useState(0);

  const handleTabChange = (event: React.SyntheticEvent, newValue: number) => {
    setTabIndex(newValue);
  };


  return (
    <div className={classes.all}>
    <Container>
      <div className={classes.top}>
      <Tabs value={tabIndex} onChange={handleTabChange}>
        <Tab label="Explore" />
        <Tab label="My WatchList" />
      </Tabs>
      </div>
      <div className={classes.bottom}>
        {tabIndex === 0 && <ExploreTab />}
        {tabIndex === 1 && <WatchListTab />} 
      </div>
    </Container>
    </div>
  );
}

export default DashboardPage;
