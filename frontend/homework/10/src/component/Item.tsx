import React from "react";
import "./Item.css";
import ListItem from "./ListItem";
import { IData } from "../Util/text";

interface ListProps {
  todos: IData[];
  onRemove: (id: number) => void;
}

function Item({ todos, onRemove }: ListProps) {
  return (
    <div className="Item-div">
      <ul id="list">
        {todos.map((item) => {
          return (
            <ListItem
              keys={item.id}
              id={item.id}
              info={{ completed: item.completed, content: item.content }}
              onRemove={onRemove}
            />
          );
        })}
      </ul>
    </div>
  );
}

export default Item;
