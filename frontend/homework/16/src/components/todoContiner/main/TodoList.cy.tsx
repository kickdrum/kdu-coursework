import { TodoList } from "./TodoList";
import { Provider } from "react-redux";
import { store } from "../../../state/store";
import { InputField } from "../InputItems/InputField";

describe("<TodoList />", () => {
  beforeEach(() => {
    cy.mount(
      <Provider store={store}>
        <InputField />
        <TodoList />
      </Provider>
    );
  });

  it("renders heading and handles no tasks case", () => {
    cy.contains("h2", "Items").should("exist");
    cy.contains("p", "No tasks to show").should("exist");
  });

  it("renders todo list items and handles delete button", () => {
    const item1 = "Item 1";
    cy.get('input[type="text"]').type(item1);
    cy.get("button").click();
    cy.contains(item1).should("exist");

    cy.get("li").should("have.length", 1);
    cy.get("li").first().find(".delete-btn").click();
    cy.get("li").should("have.length", 0);
  });
});
