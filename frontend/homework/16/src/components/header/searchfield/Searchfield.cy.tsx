import { Searchfield } from "./Searchfield";
import { Provider } from "react-redux";
import { store } from "../../../state/store";

describe("<Searchfield />", () => {
  beforeEach(() => {
    cy.mount(
      <Provider store={store}>
        <Searchfield />
      </Provider>
    );
  });

  it("renders input field", () => {
    cy.get('input[type="text"]').should("exist");
  });

  it("handles search input", () => {
    cy.get('input[type="text"]').type("Test text");
    cy.get('input[type="text"]').should("have.value", "Test text");
  });
});
