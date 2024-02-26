import { useContext } from "react";
import { ProductContext } from "../context/ProductContext";
import "../styles/Navbar.css";
import { FaSearch } from "react-icons/fa";

function NavbarListPage() {
    const { setSort ,searchQuery,filter, setFilter , setSearchQuery} = useContext(ProductContext);
    

    const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchQuery(event.target.value);
      };
    
      const handleFilterChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setFilter(event.target.value);
      };
    
      const handleSortChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
        setSort(event.target.value as 'ASC' | 'DESC' | null);
      };
  return (
    <div className="navbar">
      <div className="search-bar-container">
        <input
          className="search-input"
          name="search-input"
                  placeholder="Search.."
                  value={searchQuery}
                  onChange={handleSearchChange}
        />
        <button className="search-button">
          <FaSearch className="search-icon"/>
              </button>
              
          </div>
          <div className="data-filters-options">
              <div className="filter-box">
              <label htmlFor="filter">Filter:</label>
          <select id="filter" onChange={handleFilterChange} value={filter}>
        <option value="">All Categories</option>
        <option value="electronics">Electronics</option>
        <option value="jewelery">Jewelry</option>
        <option value="men's clothing">Men's Clothing</option>
        <option value="women's clothing">Women's Clothing</option>
      </select>
          </div>
          <div className="sort-box">
      
            <label htmlFor="sortOrder">Sort:</label>
              <select id="sortOrder" onChange={handleSortChange} >
              <option value="ASC">Ascending</option>
              <option value="DESC">Descending</option>
            </select>
   
              </div>
              </div>
    </div>
  );
}

export default NavbarListPage;
