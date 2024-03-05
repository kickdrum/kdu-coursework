
import { styled } from '@mui/system';
import { Tabs } from '@mui/base/Tabs';
import { TabsList as BaseTabsList } from '@mui/base/TabsList';
import { TabPanel as BaseTabPanel } from '@mui/base/TabPanel';
import { Tab as BaseTab, tabClasses } from '@mui/base/Tab';
import Navbar from '../components/Navbar';
import { Container } from '@mui/material';
import WatchlistTab from '../components/Dashboard/WatchListTab';
import ExploreTab from '../components/Dashboard/ExploreTab';


export default function DashboardPage() {
 
    return (<>
        <Navbar/><Container>
        <Tabs defaultValue={1}>
      <TabsList>
        <Tab value={1}>Explore</Tab>
        <Tab value={2}>My Watchlist</Tab>
      </TabsList>
      <TabPanel value={1}><ExploreTab/></TabPanel>
      <TabPanel value={2}><WatchlistTab/></TabPanel>
      </Tabs>
      </Container>
   
      </>
  );
}


const Tab = styled(BaseTab)`
  font-family: 'IBM Plex Sans', sans-serif;
  color: white;
  cursor: pointer;
  font-size: 0.875rem;
  font-weight: bold;
  background-color: transparent;
  line-height: 1.5;
  padding: 8px 12px;
  margin: 6px;
  border: none;
  border-radius: 5px;
  display: flex;
  justify-content: center;
  border-bottom : 5px solid transparent;
  color:#333;

  &.${tabClasses.selected} {
    border-bottom : 5px solid #1971c2;
  }
`;

const TabPanel = styled(BaseTabPanel)`
  width: 100%;
  font-family: 'IBM Plex Sans', sans-serif;
  font-size: 0.875rem;
`;

const TabsList = styled(BaseTabsList)`
  min-width: 400px;
  border-radius: 12px;
  margin-bottom: 16px;
  display: flex;
  align-items: center;
  align-content: space-between;
  `;


