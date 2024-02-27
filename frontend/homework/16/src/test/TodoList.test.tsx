import { render, screen } from '@testing-library/react';
import TodoList from '../todo-list/TodoList';
import { Provider } from 'react-redux';
import { store } from '../redux/store';

describe('<TodoList />', () => {
  it('renders header', () => {
    render(<Provider store={store}><TodoList /></Provider>);
    const headerElement = screen.getByText(/Item Lister/i);
    expect(headerElement).to.exist;
  });

  it('renders AddItem component', () => {
    render(<Provider store={store}><TodoList /></Provider>);
    const addItemElement = screen.getByText(/Add Items/i);
    expect(addItemElement).to.exist;
  });
});
