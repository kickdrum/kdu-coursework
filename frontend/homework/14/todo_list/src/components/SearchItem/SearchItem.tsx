import React from "react";
import { useItemContext } from "../../context/ItemContext";
import './SearchItem.scss'

const SearchItem:React.FC = () => {
    const { setSearchText } = useItemContext();

    const handleSearchInput = (event: React.ChangeEvent<HTMLInputElement>) => {
        setSearchText(event.target.value);
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
