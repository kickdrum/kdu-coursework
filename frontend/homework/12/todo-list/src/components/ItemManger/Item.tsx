import React, { useContext } from 'react';
import "../../styles/ItemManagerStyles/Item.css"
import { ItemContext } from '../../context/ItemContext';




function Item({ id, name,}: any) {
  const { items, setItems } = useContext(ItemContext);
    const deleteItem = (itemId: number) => {
        setItems(items.filter((item: { id: number; }) => item.id !== itemId));
    };
    
  const handleDelete = async () => {
    try {
       deleteItem(id);
    } catch (error) {
      console.error('Error deleting item:', error);
    }
  };
    return ( 
        <div className="Item">
            <div className="item-info">
                <h2>{name}</h2>
            </div>
            <div className="delete-button-div">
                <button className='delete-button' onClick={handleDelete}>X</button>
            </div>
        </div>
     );
}

export default Item;
