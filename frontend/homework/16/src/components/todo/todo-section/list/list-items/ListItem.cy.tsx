import { ListItem } from './ListItem';

describe('<ListItem />', () => {
  it('renders', () => {
    cy.mount(<ListItem text="Test Item" id="1" onRemove={() => {}} />);

    cy.get('.list-item').contains('Test Item').should('exist');

    cy.get('button').should('exist');
  });

  it('triggers remove action when remove button is clicked', () => {
    const removeSpy = cy.spy();

    cy.mount(<ListItem text="Test Item" id="1" onRemove={removeSpy} />);

    cy.get('button').click();

    cy.wrap(removeSpy).should('have.been.calledWith', '1');
  });
});
