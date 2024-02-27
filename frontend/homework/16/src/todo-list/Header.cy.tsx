import { Header } from './Header';
import { store } from '../redux/store';
import { Provider } from 'react-redux';

describe('<Header />', () => {
 
  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <Header />
      </Provider>
    );
    cy.get('.header').should('exist');
  });

  it('displays the correct header text', () => {
    cy.mount(
      <Provider store={store}>
        <Header />
      </Provider>
    );
    cy.get('#header').should('contain.text', 'Item Lister');
  });

  it('displays the search list component', () => {
    cy.mount(
      <Provider store={store}>
        <Header />
      </Provider>
    );
  });
});
