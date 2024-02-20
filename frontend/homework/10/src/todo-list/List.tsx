import "./List.scss";
import { ListItem } from "./ListItem";

export interface IListItem {
    id: number;
    text: string;
}

interface ListProps {
    list: IListItem[];
    setList: React.Dispatch<React.SetStateAction<IListItem[]>>;
    searchTerm: string;
    setSearchTerm: React.Dispatch<React.SetStateAction<string>>;
}

export function List({ list, setList, searchTerm, setSearchTerm }: ListProps) {
    const filteredList = list.filter(item =>
        item.text.toLowerCase().includes(searchTerm.toLowerCase())
    );

    const handleDelete = (id: number) => {
        setList(prevList => prevList.filter(item => item.id !== id));
    };

    return (
        <ul id="list">
            {filteredList.length > 0 ? (
                filteredList.map(item => (
                    <ListItem key={item.id} text={item.text} onDelete={() => handleDelete(item.id)} />
                ))
            ) : (
                <li className="list-item">No result found</li>
            )}
        </ul>
    );
}
