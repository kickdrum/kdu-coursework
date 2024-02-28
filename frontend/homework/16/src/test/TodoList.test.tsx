import { render, screen } from '@testing-library/react';
import TodoList from '../todo-list/TodoList';
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { expect } from 'vitest';

describe('<TodoList />', () => {
  it('renders header', () => {
    render(<Provider store={store}><TodoList /></Provider>);
    const headerElement = screen.getByText(/Item Lister/i);
    expect(headerElement).not.toBeNull();
  });

  it('renders AddItem component', () => {
    render(<Provider store={store}><TodoList /></Provider>);
    const addItemElement = screen.getByText(/Add Items/i);
    expect(addItemElement).not.toBeNull();
  });
});
