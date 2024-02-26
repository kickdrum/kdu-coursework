import { createContext, useState } from 'react';
import { ITodoItem } from './interfaces/ITodoItem';

export interface ITodoListContext {
  todoList: ITodoItem[];
  setTodoList: React.Dispatch<React.SetStateAction<ITodoItem[]>>;
}

export const TodoListContext = createContext<ITodoListContext>({
  todoList: [],
  setTodoList: () => { }
});

interface ITodoListProviderProps {
  children: React.ReactNode;
}

export const TodoListProvider = ({ children }: ITodoListProviderProps) => {
  const [todoList, setTodoList] = useState<ITodoItem[]>([]);

  return (
    <TodoListContext.Provider value={{ todoList, setTodoList }}>
      {children}
    </TodoListContext.Provider>
  );
};
