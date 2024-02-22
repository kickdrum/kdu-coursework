import { useEffect } from 'react';
import '../../styles/common.scss';
import './Search.scss';

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


export const Search = ({ todoData, setTodoData, searchKey, setSearchKey }: IHeaderProps) => {

    useEffect(() => {

        let updatedData = todoData.map((curr: ITodoItem) => {

            curr.isValid = true;
            return curr;
        })

        setTodoData([...updatedData]);

        if (searchKey === "") {
            return;
        }

        updatedData = todoData.map((curr: ITodoItem) => {

            let content = curr.content;

            if (content.includes(searchKey)) {
                curr.isValid = true;
            }
            else {
                curr.isValid = false;
            }

            return curr;
        })

        setTodoData([...updatedData]);

    }, [searchKey]);

    const changeHandler = (event: any) => {
        setSearchKey(event.target.value);
    }

    return (
        <input
            id='searchInputBox'
            type="text"
            placeholder='Search Items...'
            onChange={changeHandler}
            value={searchKey}
        />
    );
}
