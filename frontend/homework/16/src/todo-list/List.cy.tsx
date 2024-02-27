import { List } from './List';
import { store } from '../redux/store';
import { Provider } from 'react-redux';

describe('<List />', () => {
  
  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <List />
      </Provider>
    );
    cy.get('#list').should('exist');
  });

  it('displays "No result found" when there are no items', () => {
    cy.mount(
      <Provider store={store}>
        <List />
      </Provider>
    );
    cy.get('.list-item').should('have.length', 1);
    cy.get('.list-item').contains('No result found');
  });

  it('displays list items when there are items', () => {
    // Dispatch action to add items to the store
    const items = [{ id: 1, text: 'Item 1' }, { id: 2, text: 'Item 2' }];
    items.forEach((item) => {
      store.dispatch({ type: 'list/addTodo', payload: item });
    });

  });

  it('removes item when delete button is clicked', () => {
    // Dispatch action to add items to the store
    const items = [{ id: 1, text: 'Item 1' }, { id: 2, text: 'Item 2' }];
    items.forEach((item) => {
      store.dispatch({ type: 'list/addTodo', payload: item });
    });
    cy.mount(
      <Provider store={store}>
        <List />
      </Provider>
    );
  });
});
