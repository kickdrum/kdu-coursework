import React from "react";
import "./ListItem.css";
interface ListItemProps {
  id: number; 
  content: string;
  completed: boolean;
}

function ListItem({ keys, id, info, onRemove }: any) {
  const handleRemove = () => {
    console.log(id);
    onRemove(id);
  };

  console.log(info);
  return (
    <li className="list-item">
      <p className="text">{info.content} </p>
      <button className="x" onClick={handleRemove}>
        x
      </button>
    </li>
  );
}

export default ListItem;
