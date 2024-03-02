import { TodoSection } from './TodoSection';
import { Provider } from 'react-redux';
import { store } from '../../../redux/store';

describe('<TodoSection />', () => {
  beforeEach(() => {
    cy.mount(<Provider store={store}><TodoSection /></Provider>);
  });

  it('renders', () => {
    cy.get('.todo-section').should('exist');
  });

  it('displays "Add Items" heading', () => {
    cy.get('.todo-section h2').should('exist').and('contain', 'Add Items');
  });
});
