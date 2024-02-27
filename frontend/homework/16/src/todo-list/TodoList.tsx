import { Header } from './Header';
import { AddItem } from './Additem';
import { List } from './List';
import './TodoList.scss'

export default function TodoList() {
  return (
    <div className="todo-list">
      <Header />
      <div className="items">
        <h2 className="add-item">Add Items</h2>
        <AddItem />
        <h2 className="add-item">Items</h2>
        <List />
      </div>
    </div>
  );
}

