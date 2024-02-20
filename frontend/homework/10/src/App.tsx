import { useState } from 'react';
import "./App.scss";
import Header from './components/Header';
interface Todo {
  id: number;
  text: string;
  completed: boolean;
}

const App: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>([
  ]);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const [todo, setTodo] = useState<string>('');

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setTodo(e.target.value);
  };

  const handleFormSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    if (todo !== '') {
      setTodos([
        ...todos,
        {
          id: todos.length + 1,
          text: todo.trim(),
          completed: false,
        },
      ]);
    }

    setTodo('');
  };

  const handleDeleteClick = (id: number) => {
    const removeItem = todos.filter((todo) => todo.id !== id);
    setTodos(removeItem);
  };



  const filteredTodos = todos.filter((todo) => todo.text.toLowerCase().includes(searchTerm.toLowerCase()));

  return (
    <div className="App">
      <Header/>
      <div className="app-header">
      <h2>Add Items</h2>
          <form className='add-todo' onSubmit={handleFormSubmit}>
            
            <label htmlFor="todo"></label>
            <input name="todo"  type="text" placeholder="Create a new todo" value={todo} onChange={handleInputChange} />
            <button className='submit' type="submit">Submit</button>
          </form>
        

        <input type="text" placeholder="Search todos..." value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} className='search' />

        <h2>Items</h2>
        <ul className="todo-list">

          {filteredTodos.length === 0 && <p>No items found</p>}


          {filteredTodos.map((todo) => (
            <li className='items' key={todo.id}>
              {todo.text}
              <button className='delete-btn' onClick={() => handleDeleteClick(todo.id)}>X</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default App;