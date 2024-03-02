import './TodoSection.scss';
import { List } from "./list/List";
import { TodoInput } from "./todo-input/TodoInput";

export function TodoSection() {

    return (
        <div className="todo-section">
            <h2>Add Items</h2>
            <TodoInput />
            <List />
        </div>
    );
}