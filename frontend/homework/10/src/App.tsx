import React from 'react';
import './App.css';
import { UserBox } from './components/UserBoxComponent/UserBox';
import { userData } from './store/userdata';

function App() {

  return (
    <UserBox userData={userData}/>
  );
}

export default App;
