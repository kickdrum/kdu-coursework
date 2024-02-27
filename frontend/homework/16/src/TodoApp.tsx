import { useSelector} from "react-redux";
import { RootState } from "./redux/store";
import Header from "./Header";
import AddItem from "./AddItem";
import TodoItem from "./TodoItem";
import "./Todoapp.scss";

function TodoApp() {
  const items = useSelector((state: RootState) => state.todo.items);
  const searchTerm = useSelector((state: RootState) => state.todo.searchTerm);

  const filteredItems = items.filter((item) =>
    item.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="todo-app">
      <Header />
      <div className="content">
        <div className="add-item">
          <AddItem />
        </div>
        <div className="todo-items">
          {filteredItems.length > 0 ? (
            <ul className="todo-list">
              {filteredItems.map((item) => (
                <TodoItem key={item.id} id={item.id} name={item.name} />
              ))}
            </ul>
          ) : (
            <p className="no-match">No Match found</p>
          )}
        </div>
      </div>
    </div>
  );
}

export default TodoApp;
