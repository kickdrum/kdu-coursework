import React from "react";
import './SearchItem.scss'
import { useDispatch } from "react-redux";
import { setSearchText } from "../../redux/slice/searchSlice";

const SearchItem:React.FC = () => {
    const dispatch = useDispatch();


    const handleSearchInput = (event: React.ChangeEvent<HTMLInputElement>) => {
        dispatch(setSearchText(event.target.value))
    };

    return (
        <div className="search-input-container">
            <input
                className="search-input"
                type="text"
                placeholder="Search Items..."
                onChange={handleSearchInput}
            />
        </div>
    );
};

export default SearchItem;
