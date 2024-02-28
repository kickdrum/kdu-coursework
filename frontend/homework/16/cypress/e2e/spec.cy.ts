describe('Todo List Application', () => {
  beforeEach(() => {
    // Visit the application URL before each test
    cy.visit('http://localhost:5173');
  });
  
  it('should display header and input fields', () => {
    // Assert that header is visible
    cy.get('.header').should('be.visible');

    // Assert that input fields for adding items and searching are visible
    cy.get('.add-input').should('be.visible');
    cy.get('.search').should('be.visible');
  });

  it('should add a todo item', () => {
    // Type a todo item in the input field
    cy.get('.add-input').type('Buy groceries');

    // Click the submit button to add the todo item
    cy.get('.add').click();

    // Assert that the todo item appears in the list
    cy.contains('Buy groceries').should('be.visible');
  });

  it('should delete a todo item', () => {
    // Add a todo item to the list
    cy.get('.add-input').type('Finish homework');
    cy.get('.add').click();

    // Click the delete button for the added todo item
    cy.get('.btn-dlt').click();

    // Assert that the todo item is removed from the list
    cy.contains('Finish homework').should('not.exist');
  });

  it('should filter todo items based on search term', () => {
    // Add multiple todo items to the list
    cy.get('.add-input').type('Buy groceries');
    cy.get('.add').click();
    cy.get('.add-input').type('Finish homework');
    cy.get('.add').click();
    cy.get('.add-input').type('Walk the dog');
    cy.get('.add').click();

    // Type a search term in the search input field
    cy.get('.search').type('homework');

    // Verify that only the todo items containing the search term are displayed
    cy.contains('Buy groceries').should('not.exist');
    cy.contains('Finish homework').should('be.visible');
    cy.contains('Walk the dog').should('not.exist');
  });

});
