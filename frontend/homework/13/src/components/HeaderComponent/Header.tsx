import '../../styles/common.scss';
import './Header.scss';
import { Search } from '../SearchComponent/Search'


interface ITodoItem {
  id: number;
  content: string;
  isValid: boolean;
}

interface IHeaderProps {
  todoData: ITodoItem[];
  setTodoData: React.Dispatch<React.SetStateAction<ITodoItem[]>>;
  searchKey: string;
  setSearchKey: React.Dispatch<React.SetStateAction<string>>;
}

export const Header = ({todoData, setTodoData, searchKey, setSearchKey}: IHeaderProps) => {

  return (
    <div className='headerBox'>
      <div className="headerContent">
        <h1 className='heading1'>Item Lister</h1>
        <Search searchKey={searchKey} setSearchKey={setSearchKey} todoData={todoData} setTodoData={setTodoData} />
      </div>
    </div>
  )
}
