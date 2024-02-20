import './App.scss'
import React, { useState } from 'react';

import { IListItem } from "./todo-list/List";

import { TodoList } from "./todo-list/TodoList";

function App() {
  const [list,setList]= useState<IListItem[]>([
  ]);

  const [searchTerm, setSearchTerm] = useState('');

  return (
    <TodoList list={list} setList={setList} searchTerm={searchTerm} setSearchTerm={setSearchTerm}/>
  );
}

export default App;
