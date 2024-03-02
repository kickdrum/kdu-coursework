import { Header } from './Header'
import { Provider } from 'react-redux'
import { store } from '../../../redux/store'

describe('<Header />', () => {

  beforeEach(() => {
    cy.mount(
      <Provider store={store}>
        <Header />
      </Provider>
    );
  });

  it('renders the header with correct text', () => {
    cy.contains('Item Lister').should('exist')
  });
})  