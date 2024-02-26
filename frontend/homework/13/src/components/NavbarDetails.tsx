import "../styles/Navbar.css";
import { FaSearch } from "react-icons/fa";
function NavbarDetails() {
  return (
    <div className="navbar">
      <div className="search-bar-container">
        <input
          className="search-input"
          name="search-input"
          placeholder="Search.."
        />
        <button className="search-button">
          <FaSearch className="search-icon"/>
        </button>
      </div>
    </div>
  );
}

export default NavbarDetails;
