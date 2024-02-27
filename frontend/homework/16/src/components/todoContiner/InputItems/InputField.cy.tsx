import { InputField } from "./InputField";
import { Provider } from "react-redux";
import { store } from "../../../state/store";

describe("<InputField />", () => {
  beforeEach(() => {
    cy.mount(
      <Provider store={store}>
        <InputField />
      </Provider>
    );
  });

  
  it("renders input field and submit button and heading", () => {
    cy.get('input[type="text"]').should("exist");
    cy.get('button[type="submit"]').should("exist");
    cy.get("p").should("have.text", "Add Items");
  });

  it("handles input change", () => {
    cy.get('input[type="text"]').type("Test Task");

    cy.get('input[type="text"]').should("have.value", "Test Task");
  });

  it("submits the form and dispatches action", () => {
    cy.get('input[type="text"]').type("Test Task");
    cy.get('button[type="submit"]').click();
    cy.get('input[type="text"]').should("have.value", "");
  });
});
