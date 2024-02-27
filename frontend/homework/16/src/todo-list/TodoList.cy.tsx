import { Provider } from 'react-redux';
import { store } from '../redux/store';
import TodoList from './TodoList';

describe('<TodoList />', () => {

  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <TodoList />
      </Provider>
    );
    cy.get('.todo-list').should('exist');
  });

  it('renders header component', () => {
    cy.mount(
      <Provider store={store}>
        <TodoList />
      </Provider>
    );
    cy.get('.header').should('exist');
  });

  it('renders add item component', () => {
    cy.mount(
      <Provider store={store}>
        <TodoList />
      </Provider>
    );
    cy.get('.add-item').should('exist');
  });

  it('renders list component', () => {
    cy.mount(
      <Provider store={store}>
        <TodoList />
      </Provider>
    );
    cy.get('.todo-list').should('exist');
  });
});
