import { SearchList } from './SearchList';
import { store } from '../redux/store';
import { Provider } from 'react-redux';

describe('<SearchList />', () => {
  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <SearchList />
      </Provider>
    );
    cy.get('.search').should('exist');
  });

  it('dispatches setSearchTerm action on input change', () => {
    const searchTerm = 'Test';
    cy.mount(
      <Provider store={store}>
        <SearchList />
      </Provider>
    );
    cy.get('.search').type(searchTerm);
  });
});
