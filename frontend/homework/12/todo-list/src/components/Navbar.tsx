import React, { useContext } from 'react';
import "../styles/Navbar.css"
import { SearchContext } from '../context/SearchContext';



function Navbar() {
    const { searchQuery, setSearchQuery } = useContext(SearchContext);
    return ( 

        <div className="navbar-container">
            <div className="navbar-heading"><h2>Item Lister</h2></div>
            <div className="search-bar">
                <input type="text" name='search-bar'
                         value={searchQuery}
                         onChange={(e) => setSearchQuery(e.target.value)}
                    placeholder='Search items...' />
            </div>
        </div>
     );
}

export default Navbar;