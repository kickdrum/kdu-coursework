import React, { useState } from "react";
import "./Header.css";
import { event } from "cypress/types/jquery";
interface HeaderProps {
  onSearch: (query: string) => void;
}
function Header({ onSearch }: HeaderProps) {
  const [searchQuery, setSearchQuery] = useState("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const query = event.target.value;
    setSearchQuery(query);
    onSearch(query);
  };
  return (
    <div>
      <div className="header">
        <div>
          <p className="header-txt">Item Lister</p>
        </div>
        <div>
          <input
            type="text"
            id="textArea"
            placeholder="search here"
            value={searchQuery}
            onChange={handleInputChange}
          />
        </div>
      </div>
    </div>
  );
}

export default Header;
