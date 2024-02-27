import { Provider } from 'react-redux';
import { store } from './redux/store';
import TodoApp from './TodoApp';
import { PersistGate } from 'redux-persist/integration/react'
import { persistStore } from 'redux-persist'
function App() {
  let persistor = persistStore(store);
  return (
    <div>
      <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <TodoApp />
        </PersistGate>
      </Provider>
    </div>
  );
}

export default App;
