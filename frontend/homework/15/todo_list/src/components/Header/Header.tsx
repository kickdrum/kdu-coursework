import React from "react";
import SearchItem from "../SearchItem/SearchItem";
import './Header.scss'
import '../Timer/Timer.scss'
import Timer from "../Timer/Timer";

const Header:React.FC = () => {

  return (
    <div className="main-header">
        <h1 className="main-heading">Item Lister</h1>
        <Timer />
        <SearchItem/>
    </div>
  );
};

export default Header;
