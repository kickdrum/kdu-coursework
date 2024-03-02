// import { List } from './List'
// import { store } from '../../../../redux/store'
// import { Provider } from 'react-redux'

// describe('<List />', () => {
//   it('renders', () => {
//     // see: https://on.cypress.io/mounting-react
//     cy.mount( <Provider store = {store}><List /></Provider>)
//   })
// })

import React from 'react';
import { Provider } from 'react-redux';
import { store } from '../../../../redux/store';
import { List } from './List';
import { TodoInput } from '../todo-input/TodoInput';

describe('<List /> component test', () => {
  beforeEach(() => {
    // Mount the List component with Redux Provider
    cy.mount(
      <Provider store={store}>
        <TodoInput/>
        <List />
      </Provider>
    );
  });

  it('renders with no tasks', () => {
    // Check if the list container exists
    cy.get('#list').should('exist');

    // Check if the "Add tasks..." message is displayed
    cy.get('.no-task-found').should('contain', 'Add tasks...');
  });

  it('renders tasks and handles removal', () => {
    // Add some tasks
    const tasks = [
      { id: '1', text: 'Task 1' },
      { id: '2', text: 'Task 2' }
    ];
    cy.window().its('store').invoke('dispatch', { type: 'SET_TODO_LIST', payload: tasks });

    // Check if the tasks are rendered
    cy.get('.list-item').should('have.length', 2);

    // Remove a task
    cy.get('.remove-button').first().click();

    // Check if the task is removed from the list
    cy.get('.list-item').should('have.length', 1);
  });

  it('filters tasks based on search input', () => {
    // Add some tasks
    const tasks = [
      { id: '1', text: 'Task 1' },
      { id: '2', text: 'Task 2' }
    ];
    cy.window().its('store').invoke('dispatch', { type: 'SET_TODO_LIST', payload: tasks });

    // Type a search query in the search input
    cy.get('.search-input').type('Task 1');

    // Check if only the filtered task is rendered
    cy.get('.list-item').should('have.length', 1).should('contain', 'Task 1');
  });
});
