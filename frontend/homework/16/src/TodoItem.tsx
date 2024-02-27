import { useDispatch } from "react-redux";
import { deleteItem } from "./redux/todoSlice";
import "./todoitem.scss";
import deleteIcon from "./delete.png";

interface TodoItemProps {
  id: number;
  name: string;
}

const TodoItem = ({ id, name }: TodoItemProps) => {
  const dispatch = useDispatch();

  const handleDeleteClick = () => {
    dispatch(deleteItem(id));
  };

  return (
    <div className="todo-item">
      <li key={id} className="todo-item-li">
        <div className="itemName">{name}</div>
        <button className="delete" onClick={handleDeleteClick}>
          <img src={deleteIcon} alt="Delete" className="delete-icon" />
        </button>
      </li>
    </div>
  );
};

export default TodoItem;
