import '../../styles/common.scss';
import './CheckList.scss';
import { ListItem } from '../ListItemComponent/ListItem';


interface ITodoItem {
    id: number;
    content: string;
    isValid: boolean;
}

interface ICheckListProp {
    todoData: ITodoItem[];
    deleteTodo: (id: number) => void;
}


export const CheckList = ({ todoData, deleteTodo }: ICheckListProp) => {

    let validCount = 0;

    todoData.forEach(curr => {
        let val = curr.isValid ? 1 : 0;
        validCount += val;
    })

    if (todoData.length === 0) {
        return (
            <div className='checkList'>
                <h4 className='heading4'>No more tasks!!</h4>
            </div>
        )
    }
    else if (validCount === 0) {
        return (
            <div className='checkList'>
                <h4 className='heading4Red'>No Match found!!</h4>
            </div>
        )
    }
    else {

        return (
            <div className='checkList'>

                {todoData.map((currTodo) => {

                    if (!currTodo.isValid) {
                        return "";
                    }

                    return (
                        <ListItem key={currTodo.id} itemData={currTodo} deleteTodo={deleteTodo} />
                    )
                })}

            </div>
        )

    }


}
