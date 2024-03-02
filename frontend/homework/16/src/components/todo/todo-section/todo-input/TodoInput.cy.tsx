import { TodoInput } from './TodoInput'
import { Provider } from 'react-redux'
import { store } from '../../../../redux/store'

describe('<TodoInput />', () => {

  beforeEach(() => {
    
    cy.mount(
      <Provider store={store}>
        <TodoInput />
      </Provider>
    );
  });

  it('allows typing into input field and submitting', () => {
    const todoText = 'Test Todo Item';
  
    cy.get('.todo-input')
      .type(todoText)
      .should('have.value', todoText); 
  
    cy.get('.submit').click();
  
    cy.get('.todo-input').should('have.value', '');
  
  });
});
