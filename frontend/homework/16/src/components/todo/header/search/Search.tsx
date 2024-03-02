import { setSearchBar } from "../../../../redux/SearchSlice";
import { RootState } from "../../../../redux/store";
import "./Seach.scss";
import { useDispatch, useSelector } from "react-redux";

export function Search(){
    
    const searchBar = useSelector((state: RootState ) => state.search.searchBar);
    const searchDispatch = useDispatch();

    function searchHandler(event: React.ChangeEvent<HTMLInputElement>){
        const newValue = event.target.value;
        searchDispatch(setSearchBar(newValue));
        console.log(newValue);
    }
    
    return (
        <input 
        type="text" 
        id="search" 
        placeholder="Search Items..."
        value={searchBar}
        onChange={(e) => searchHandler(e)}
        />
    );
}
