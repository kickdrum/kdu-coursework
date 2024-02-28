import { useContext, useRef } from "react";
import { ProductsContext } from "../ProductsContext"; 
import { useNavigate } from "react-router-dom";
import './Navbar.scss'


export function Navbar() {
  const { setSearch } = useContext(ProductsContext);
  const { setSorting} = useContext(ProductsContext);

  const searchBarRef = useRef<HTMLInputElement>(null);
  const sortRef = useRef<HTMLSelectElement>(null);

  const navigate = useNavigate();

  const handleSearch = () => {
    navigate("/")
    if (searchBarRef.current) {
      setSearch(searchBarRef.current.value)
    }
  }
  const handleSort = () => {
    if (sortRef.current) setSorting(sortRef.current.value);
  }
  return (
    <div>
        <div>
            <input type="text" placeholder="Search.." ref={searchBarRef}/>
            <button onClick={handleSearch}>
            <img src="./search.png" alt="searchLogo"/>
            </button>
        </div>
        <div>
        <div>
      <p>Sort: </p>
      <select name="" id="" ref={sortRef} onChange={handleSort}>
        <option value="">None</option>
        <option value="asc">ASC</option>
        <option value="desc">DESC</option>
      </select>
    </div>
        </div>
    </div>
  )
}
