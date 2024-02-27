import { ListItem } from './ListItem';
import { store } from '../redux/store';
import { Provider } from 'react-redux';

describe('<ListItem />', () => {
  it('renders', () => {
    cy.mount(
      <Provider store={store}>
        <ListItem text={''} onDelete={() => {}} />
      </Provider>
    );
    cy.get('.list-item').should('exist');
  });

  it('displays text correctly', () => {
    const text = 'Test Item';
    cy.mount(
      <Provider store={store}>
        <ListItem text={text} onDelete={() => {}} />
      </Provider>
    );
    cy.get('.list-item').contains(text);
  });

  it('triggers onDelete function when delete button is clicked', () => {
    let onDeleteCalled = false;
    cy.mount(
      <Provider store={store}>
        <ListItem text={''} onDelete={() => (onDeleteCalled = true)} />
      </Provider>
    );
    cy.get('.btn-dlt').click().then(() => {
      expect(onDeleteCalled).to.be.true;
    });
  });
});
