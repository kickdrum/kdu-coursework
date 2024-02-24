import { useContext, useState } from "react"
import { FilterAndSortContext, SearchItemContext } from "./Main"
import "./styles/Navigation.scss"
export function Navigation() {
    const [searchItem,setSearchItem] = useState<string>('');

    const {updateSearchTerm} = useContext(SearchItemContext);

    const {updateFilter,updateSort} = useContext(FilterAndSortContext);

    const updateFiltering = (event : React.ChangeEvent<HTMLSelectElement>) => {
      const selectedFilter = event.target.value;
      updateFilter(selectedFilter);
    };
  
    const handleSortChange = (event:React.ChangeEvent<HTMLSelectElement>) => {
      const selectedSort = event.target.value;
      updateSort(selectedSort);
    };
    const updateSearchItem = (event : React.ChangeEvent<HTMLInputElement>)=>{
        const searching = event.target.value;
        setSearchItem(searching);
        console.log('changing search');
    }

    const showUpdatedArray = ()=>{
        updateSearchTerm(searchItem);
        console.log('updating search result');
    }


  return (
    <div className="navigation-container">
        <div className="search-container">
            <input type="text" value={searchItem}  placeholder="search Items.." onChange={updateSearchItem}></input>
            <button onClick={showUpdatedArray}>Search</button>
        </div>
        <div className="filter_sort-container">
            <span>Filter</span>
        <select name="filter" onChange={updateFiltering}>
            <option value="electronics">Electronics</option>
            <option value="jewelery">Jewelry</option>
            <option value="men's clothing">Men's Clothing</option>
            <option value="women's clothing">Women's Clothing</option>
        </select>
        <span>Sort</span>
        <select name="sort" onChange={handleSortChange}>
            <option value="price">Price</option>
            <option value="rating">Rating</option>
        </select>
        </div>
    </div>
  )
}
