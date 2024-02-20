import "./Header.scss";
import { IListItem } from "./List";
import { SearchList } from './SearchList';

interface TodoListProps {
  list: IListItem[]
  setList: React.Dispatch<React.SetStateAction<IListItem[]>>
  searchTerm: string;
  setSearchTerm: React.Dispatch<React.SetStateAction<string>>;
}

export function Header({list, setList, searchTerm, setSearchTerm}: TodoListProps) {
  return (
    <div className="header">
      <h1 id="header">Item Lister</h1>
      <SearchList list={list} setList={setList} searchTerm={searchTerm} setSearchTerm={setSearchTerm}/>
    </div>
  )
}
