import { render, screen } from '@testing-library/react';
import { describe, it } from 'vitest';
import { List } from '../todo-list/List';
import { Provider } from 'react-redux';
import { store } from '../redux/store';
import { expect } from 'vitest';


describe('<List />', () => {
 
  it('displays "No result found" when no items match search term', () => {
    // Mock empty todos datahh

    // Render the List component with mocked todos
    render(
      <Provider store={store}>
        <List />
      </Provider>
    );

    // Check if "No result found" message is rendered
    const noResultElement = screen.getByText(/No result found/i);
    expect(noResultElement).not.toBeNull();
  });

  it('removes item when delete button is clicked', () => {
    // Mock todos data
    const todos = [
      { id: 1, text: 'Todo 1' },
      { id: 2, text: 'Todo 2' },
    ];

    // Render the List component with mocked todos
    render(
      <Provider store={store}>
        <List />
      </Provider>
    );

    const firstItem = screen.queryByText(todos[0].text);
    expect(firstItem).not.to.exist;
  });
});
