import { Header } from "./Header";
import { AddItem } from "./Additem"
// import { IListItem, List } from "./List";
import { List } from "./List";


import "./TodoList.scss";

// interface TodoListProps {
//     list: IListItem[]
//     setList: React.Dispatch<React.SetStateAction<IListItem[]>>
//     searchTerm: string;
//     setSearchTerm: React.Dispatch<React.SetStateAction<string>>
// }

export function TodoList(){

    return (
        <div className="todo-list">
            <Header/>
        <div className="items">
            <h2 className="add-item">Add Items</h2>
            <AddItem />
            <h2 className="add-item">Items</h2>
            <List />
        </div>
        </div>
    )
}
