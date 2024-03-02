import './App.css';
import { TodoListProvider } from './TodoListProvider';
import { Todo } from './components/todo/TodoList';

function App() {
  

  return (
    <TodoListProvider>
      <Todo />
    </TodoListProvider>
  );
}

export default App;