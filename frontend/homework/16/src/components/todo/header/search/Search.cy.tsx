import { Search } from './Search';
import { Provider } from 'react-redux';
import { store } from '../../../../redux/store';

describe('<Search />', () => {
  beforeEach(() => {
    cy.mount(<Provider store={store}><Search /></Provider>);
  });

  it('renders', () => {
    cy.get('#search').should('exist');
  });

  it('displays placeholder text', () => {
    cy.get('#search').should('have.attr', 'placeholder', 'Search Items...');
  });

  it('updates search bar value', () => {
    const typedText = 'Sample Search';
    cy.get('#search').type(typedText).should('have.value', typedText);
  });

});
