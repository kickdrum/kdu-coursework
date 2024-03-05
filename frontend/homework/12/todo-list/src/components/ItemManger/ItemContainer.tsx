import React, { useContext, useEffect, useState } from "react";
import "../../styles/ItemManagerStyles/ItemContainer.css";
import Item from "./Item";
import { ItemProps } from "../../types/ItemProps";
import { ItemContext } from "../../context/ItemContext";
import { SearchContext } from "../../context/SearchContext";

function ItemContainer() {
  const { searchQuery } = useContext(SearchContext);
  const [filteredItems, setFilteredItems] = useState<ItemProps[]>([]);
  const [name, setName] = useState("");
  const [showList, setShowList] = useState(false);
  const [items, setItems] = useState([{ id: 1, name: "Item 1" }]);

  const addItem = (newItemName: string) => {
    const newItem = { id: items.length + 1, name: newItemName };
    setItems([...items, newItem]);
  };

  useEffect(() => {
    const updatedItems = items.filter((item) =>
      item.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    setFilteredItems(updatedItems);
    setShowList(updatedItems.length > 0 && searchQuery !== ""); // Only show if items or searchQuery exists
  }, [searchQuery, items]);

  return (
    <div className="Item-Container">
      <div className="search-result-Container">
        {showList && (
          <ul>
            {filteredItems.map((item) => (
              <ItemContext.Provider value={{ items ,setItems }}>
              <Item key={item.id} name={item.name} id={item.id} />
              </ItemContext.Provider>
            ))}
          </ul>
        )}
        {!showList && searchQuery && <p>No match found</p>}
        {/* Other components */}
      </div>
      <div className="Item-container-heading">
        <h1>Add Items</h1>
      </div>
      <div className="Item-add-box">
        <form
          onSubmit={(e) => {
            e.preventDefault();
            addItem(name);
          }}
        >
          <div className="input-box">
            <input
              type="text"
              name="add-item"
              id="add-input"
              onChange={(e) => setName(e.target.value.trim())}
            />
          </div>
          <div className="submit-div">
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
      <div className="items">
        {items.map((item) => (
           <ItemContext.Provider value={{ items ,setItems }}>
           <Item key={item.id} name={item.name} id={item.id} />
           </ItemContext.Provider>
        ))}
      </div>
    </div>
  );
}

export default ItemContainer;
