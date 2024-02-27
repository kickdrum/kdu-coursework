import { Headingtext } from './Headingtext'

describe('<Headingtext />', () => {
  beforeEach(()=> {
    cy.mount(
  <Headingtext/>
    );
  });

  it("renders text", () => {
    cy.get("h1").should("have.text", "Item Lister");
  })
})

