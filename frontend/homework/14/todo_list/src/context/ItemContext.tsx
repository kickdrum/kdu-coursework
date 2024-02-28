import React, { useContext, useMemo, useState } from "react";


type ItemContextType = {
    todoItems: string[];
    setTodoItems: React.Dispatch<React.SetStateAction<string[]>>;
    searchText: string;
    setSearchText: React.Dispatch<React.SetStateAction<string>>;
    allTodoItems: string[];
    setAllTodoItems: React.Dispatch<React.SetStateAction<string[]>>;

}

const ItemContext = React.createContext<ItemContextType | null>(null);


export const ItemProvider: React.FC<{ children: React.ReactNode }> = ({
    children,
}) => {
    const [todoItems, setTodoItems] = useState<string[]>([]);
    const [searchText,setSearchText] = useState<string>("");
    const [allTodoItems, setAllTodoItems] = useState<string[]>([]);


    return useMemo(
        () => (
            <ItemContext.Provider
                value={{
                    todoItems,
                    setTodoItems,
                    searchText,
                    setSearchText,
                    allTodoItems,
                    setAllTodoItems,
                }}
            >
                {children}
            </ItemContext.Provider>
        ),
        [todoItems, children,searchText,setSearchText,allTodoItems,setAllTodoItems]
    );
};


export const useItemContext = () => {
    return useContext(ItemContext) as ItemContextType;
}
