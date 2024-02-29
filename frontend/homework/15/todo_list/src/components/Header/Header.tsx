import React from "react";
import SearchItem from "../SearchItem/SearchItem";
import './Header.scss'

const Header:React.FC = () => {

  return (
    <div className="main-header">
        <h1 className="main-heading">Item Lister</h1>
        <SearchItem/>
    </div>
  );
};

export default Header;
