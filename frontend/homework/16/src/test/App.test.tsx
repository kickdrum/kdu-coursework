import { render, screen } from '@testing-library/react';
import App from "../App";
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { expect } from 'vitest';

describe('<App />', () => {
    
  it('renders without crashing', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Add Items/i)).not.toBeNull();
  });

  it('renders the TodoList component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByRole('list')).not.toBeNull();
  });

  it('renders the Header component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Item Lister/i)).not.toBeNull();
  });

  it('renders the AddItem component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByText(/Submit/i)).not.toBeNull();
  });

  it('renders the SearchList component', () => {
    render(
      <Provider store={store}>
        <App />
      </Provider>
    );
    expect(screen.getByPlaceholderText(/Search Items.../i)).not.toBeNull();
    
  });
});
