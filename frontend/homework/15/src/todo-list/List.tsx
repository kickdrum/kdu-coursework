import './List.scss';
import { useSelector, useDispatch } from 'react-redux'; 
import { RootState } from '../redux/store';
import { ListItem } from './ListItem';
import { removeTodo } from '../redux/todoSlice';

export function List() {
    const todos = useSelector((state: RootState) => state.todo.list);
    const searchTerm = useSelector((state: RootState) => state.todo.searchTerm);
    const dispatch = useDispatch(); 
    const filteredList = todos.filter((todo) =>
        todo.text.toLowerCase().includes(searchTerm.toLowerCase())
    );

    const handleDelete = (id: number) => {
        dispatch(removeTodo(id)); };

    return (
        <ul id="list">
            {filteredList.length > 0 ? (
                filteredList.map((item) => (
                    <ListItem key={item.id} text={item.text} onDelete={() => handleDelete(item.id)} />
                ))
            ) : (
                <li className="list-item">No result found</li>
            )}
        </ul>
    );
}
