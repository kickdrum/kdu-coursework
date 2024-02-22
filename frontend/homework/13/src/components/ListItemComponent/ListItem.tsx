import '../../styles/common.scss';
import './ListItem.scss';


interface ITodoItem {
    id: number;
    content: string;
}

interface IListItem {
    itemData: ITodoItem;
    deleteTodo: (id: number) => void;
}

export const ListItem = ({ itemData, deleteTodo }: IListItem) => {

    const { id, content } = itemData;

    return (
        <div className='listItem'>
            <p className='content'>{content}</p>
            <button className='deleteButton' onClick={()=>{deleteTodo(id)}}>x</button>
        </div>
    )
}
