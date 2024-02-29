import React, { useEffect } from "react";
import "./ItemContainer.scss";
import Item from "../Item/Item";
import { useSelector } from "react-redux";
import { StoreState } from "../../redux/store";

const ItemContainer:React.FC = () => {
    const allTodoItems = useSelector((state: StoreState) => state.todos);
    const searchText = useSelector((state: StoreState)=> state.search);

    useEffect(() => {
        //pass
    }, [searchText]);

    const filteredItems =
        searchText.length === 0
            ? allTodoItems
            : allTodoItems.filter((item) => item.content.includes(searchText));

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
                {filteredItems.map((item) => (
                    <Item key={item.id} id={item.id} todoContent={item.content} />
                ))}
            </div>
        </div>
    );
};

export default ItemContainer;
