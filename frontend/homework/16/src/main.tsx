import ReactDOM from 'react-dom/client';
import App from './App';
import { Provider } from 'react-redux'
import { persistorList, store } from './state/store';
import React from 'react';
import { PersistGate } from 'redux-persist/integration/react';


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
   <React.StrictMode>
    <Provider store={store}>
    <PersistGate loading={<div>Loading...</div>} persistor={persistorList}>
    <App />
    </PersistGate>
    </Provider>
   </React.StrictMode>
);


