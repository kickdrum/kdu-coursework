import './App.scss';
import { Provider } from 'react-redux';
import { store } from './redux/store';
import TodoList from './todo-list/TodoList';

function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <TodoList />
      </div>
    </Provider>
  );
}

export default App;
