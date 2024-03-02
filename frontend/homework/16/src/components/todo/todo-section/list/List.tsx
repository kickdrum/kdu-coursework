import { ListItem } from "./list-items/ListItem";
import "./List.scss";
import { ITodoItem } from '../../../../interfaces/ITodoItem';
import { useDispatch, useSelector } from "react-redux";
import { RootState } from "../../../../redux/store";
import { setTodoList } from "../../../../redux/TodoSlice";

export function List() {
    const searchBar = useSelector((state: RootState) => state.search.searchBar);
    const todoList = useSelector((state: RootState) => state.todoList.todoList);
    const dispatch = useDispatch();
    
    const handleRemoveItem = (id: string) => {
        const updatedList = todoList.filter(item => item.id !== id);
        dispatch(setTodoList(updatedList));
    };

    const filteredList = todoList.filter(item =>
        item.text.toLowerCase().includes(searchBar.toLowerCase())
    );

    return (
        <ul id="list">
            {filteredList.length > 0 ? (
                filteredList.map((item: ITodoItem) => (
                    <ListItem key={item.id} text={item.text} id={item.id} onRemove={handleRemoveItem} />
                ))
            ) : (
                <div className="no-task-found">{searchBar ? "No such tasks" : "Add tasks..."}</div>
            )}  
        </ul>
    )
}
