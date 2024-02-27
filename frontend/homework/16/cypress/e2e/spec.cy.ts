import "@testing-library/cypress/add-commands";

describe("TodoList Integration Test", () => {
  beforeEach(() => {
    cy.visit("http://localhost:5174");
  });

  it("adds an item to the todo list", () => {
    cy.findByTestId("test-inputField").type("New Item");

    cy.findByTestId("test-submitBtn").click();

    cy.findByTestId("test-item0").should("contain.text", "New Item");
  });

  it("deletes an item from the todo list", () => {
    cy.findByTestId("test-inputField").type("New Task");
    cy.findByTestId("test-submitBtn").click();

    cy.findByTestId("test-item0").should("contain.text", "New Task");

    cy.findByTestId("test-item0").find(".delete-btn").click();

    cy.findByTestId("test-item0").should("not.exist");
  });

  it("performs search and filters items", () => {
    cy.findByTestId("test-inputField").type("Task 1");
    cy.findByTestId("test-submitBtn").click();
    cy.findByTestId("test-inputField").type("Task 2");
    cy.findByTestId("test-submitBtn").click();
    cy.findByTestId("test-inputField").type("Task 3");
    cy.findByTestId("test-submitBtn").click();

    cy.get('[data-testid^="test-item"]').should("have.length", 3);

    cy.findByTestId("test-searchField").type("Task 1");

    cy.get('[data-testid^="test-item"]').should("have.length", 1);
    cy.findByTestId("test-item0").should("contain.text", "Task 1");

    cy.findByTestId("test-searchField").clear();

    cy.get('[data-testid^="test-item"]').should("have.length", 3);
  });
});
