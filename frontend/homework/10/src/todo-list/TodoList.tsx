import { Header } from "./Header";
import { AddItem } from "./Additem"
import { IListItem, List } from "./List";

import "./TodoList.scss";

interface TodoListProps {
    list: IListItem[]
    setList: React.Dispatch<React.SetStateAction<IListItem[]>>
    searchTerm: string;
    setSearchTerm: React.Dispatch<React.SetStateAction<string>>;
}


export function TodoList({list, setList, searchTerm, setSearchTerm}: TodoListProps){

    return (
        <div className="todo-list">
            <Header list={list} setList={setList} searchTerm={searchTerm} setSearchTerm={setSearchTerm}/>
        <div className="items">
            <h2 className="add-item">Add Items</h2>
            <AddItem list={list} setList={setList}/>
            <h2 className="add-item">Items</h2>
            <List list={list} setList={setList} searchTerm={searchTerm} setSearchTerm={setSearchTerm}/>
        </div>
        </div>
    )
}
