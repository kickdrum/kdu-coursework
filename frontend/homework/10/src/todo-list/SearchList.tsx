import './Search.scss'
interface IListItem {
  id: number;
  text: string;
}

interface ListProps {
  list: IListItem[];
  setList: React.Dispatch<React.SetStateAction<IListItem[]>>
  searchTerm: string;
  setSearchTerm: React.Dispatch<React.SetStateAction<string>>;
}

export function SearchList({ list, setList, searchTerm, setSearchTerm }: ListProps) {

  return (
    <div>
      <input className="search"
        type="text"
        placeholder="Search Items..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
    </div>
  );
}