import { AddItem } from './Additem';
import { store } from '../redux/store';
import { Provider } from 'react-redux';

describe('<AddItem />', () => {


  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <AddItem />
      </Provider>
    );
    cy.get('.add-item').should('exist');
  });

  it('allows adding items', () => {
    const todoText = 'Test Todo Item';
    cy.mount(
      <Provider store={store}>
        <AddItem />
      </Provider>
    );
    cy.get('.add-input').type(todoText);
    cy.get('.add').click();
    cy.wait(500);
  });
});
