import React, { useEffect } from "react";
import { useItemContext } from "../../context/ItemContext";
import "./ItemContainer.scss";
import { v4 as uuidv4 } from "uuid";
import Item from "../Item/Item";

const ItemContainer:React.FC = () => {
    const { allTodoItems, searchText } = useItemContext();

    useEffect(() => {
        //pass
    }, [searchText]);

    const filteredItems =
        searchText.length === 0
            ? allTodoItems
            : allTodoItems.filter((value) => value.includes(searchText));

    return (
        <div className="main-items-container">
            <div>
                <h1>Items</h1>
            </div>
            <div className="items-list-container">
                {filteredItems.length === 0 && searchText.length !== 0 && (
                    <p className="addn-info">No Results Found</p>
                )}
                {filteredItems.length === 0 && searchText.length === 0 && (
                    <p className="addn-info">No Items Added</p>
                )}
                {filteredItems.map((todoContent) => (
                    <Item key={uuidv4()} todoContent={todoContent} />
                ))}
            </div>
        </div>
    );
};

export default ItemContainer;
