import React, { useState } from "react";
import Header from "./Header";
import Item from "./Item";
import "./TodoList.css";
import { IData } from "../Util/text";

function TodoList() {
  const [inputTxt, setInputTxt] = useState("");
  const [todos, setTodos] = useState<IData[]>([]);
  const [searchQuery, setSearchQuery] = useState("");

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setInputTxt(event.target.value);
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (inputTxt.trim() !== "") {
      const newTodo: IData = {
        id: todos.length + 1,
        content: inputTxt.trim(),
        completed: false,
      };
      setTodos([...todos, newTodo]);
      setInputTxt("");
    }
  };

  const handleRemove = (id: number) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  const handleSearch = (query: string) => {
    setSearchQuery(query);
  };

  const filteredTodos = todos.filter((todo) =>
    todo.content.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <div>
      <div className="main-section">
        <Header onSearch={handleSearch} />
        <div className="parent-div">
          <div className="todo-list">
            <h1 className="todo-heading">Add Items</h1>
            <form id="form" onSubmit={handleSubmit}>
              <div className="search-div">
                <input
                  type="text"
                  id="add-input"
                  value={inputTxt}
                  onChange={handleInputChange}
                />
                <button type="submit" id="submit-btn">
                  Submit
                </button>
              </div>
            </form>
            <p className="items">Items</p>
            <Item todos={filteredTodos} onRemove={handleRemove} />
          </div>
        </div>
      </div>
    </div>
  );
}

export default TodoList;
