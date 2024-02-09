describe("Register Form", () => {
  /**
   * Test Case: Match Baseline Screenshot on Desktop
   *
   * Test Steps:
   * 1. Visit the register page of the application.
   * 2. Take a full-page screenshot of the register page.
   * 3. Compare the screenshot with a baseline image using visual regression testing.
   *
   * Error Threshold:
   * A maximum error threshold of TEST_THRESHOLD is set, allowing for a 20% difference between
   * the captured screenshot and the baseline image.
   */
  it("should match baseline screenshot on desktop", () => {
    // Visit the register page
    cy.visit(Cypress.env("REGISTER_PAGE_URL"));

    // Take a full-page screenshot
    cy.screenshot("registerPage", { capture: "fullPage" });

    // Compare the screenshot with a baseline image
    // Error threshold set to TEST_THRESHOLD (20% difference)
    cy.compareSnapshot("registerPage", Cypress.env("TEST_THRESHOLD"));
  });

  /**
   * Test Case: Match Baseline Screenshot on iPhone XR
   *
   * Test Steps:
   * 1. Set the viewport to iPhone XR size.
   * 2. Visit the register page of the application.
   * 3. Take a full-page screenshot of the register page.
   * 4. Compare the screenshot with a baseline image using visual regression testing.
   *
   * Error Threshold:
   * A maximum error threshold of TEST_THRESHOLD is set, allowing for a 20% difference between
   * the captured screenshot and the baseline image.
   */
  it("should match baseline screenshot on iPhone XR", () => {
    // Set the viewport to iPhone XR size
    cy.viewport("iphone-xr");

    // Visit the register page
    cy.visit(Cypress.env("REGISTER_PAGE_URL"));

    // Take a full-page screenshot
    cy.screenshot("registerPage", { capture: "fullPage" });

    // Compare the screenshot with a baseline image
    // Error threshold set to TEST_THRESHOLD (20% difference)
    cy.compareSnapshot("registerPage", Cypress.env("TEST_THRESHOLD"));
  });

  /**
   * Test Case: Register with Valid Credentials on Desktop
   *
   * Test Steps:
   * 1. Visit the register page of the application.
   * 2. Retrieve email, password, username, and full name from environment variables.
   * 3. Clear input fields.
   * 4. Fill in the credentials.
   * 5. Ensure the submit button is enabled.
   * 6. Submit the form.
   * 7. Wait for the page transition to complete.
   * 8. Assert that the registration is successful by checking the URL.
   */
  it("should register in with valid credentials on desktop", () => {
    // Visit the register page before each test
    cy.visit(Cypress.env("REGISTER_PAGE_URL"));

    // Get email, password, username, and full name from environment variables
    const emailText = Cypress.env("EMAIL");
    const passwordText = Cypress.env("PASSWORD");
    const usernameText = Cypress.env("USERNAME");
    const nameText = Cypress.env("NAME");

    // Button should be disabled.
    cy.get(".submitButton").should("be.disabled");

    cy.get("#email").clear();
    cy.get("#password").clear();
    cy.get("#username").clear();
    cy.get("#name").clear();

    // Fill the credentials.
    cy.get("#email").type(emailText, { force: true });
    cy.get("#password").type(passwordText, { force: true });
    cy.get("#username").type(usernameText, { force: true });
    cy.get("#name").type(nameText, { force: true });

    // Button should be enabled.
    cy.get(".submitButton").should("not.be.disabled");

    // Submit the form
    cy.get("#register").submit();

    // Wait for the page transition to complete
    cy.wait(1000);

    // Assert that the register is successful
    cy.url().should("include", Cypress.env("LOGIN_PAGE_URL"));
  });

  /**
   * Test Case: Register with Valid Credentials on iPhone XR
   *
   * Test Steps:
   * 1. Set the viewport to iPhone XR size.
   * 2. Visit the register page of the application.
   * 3. Retrieve email, password, username, and full name from environment variables.
   * 4. Clear input fields.
   * 5. Fill in the credentials.
   * 6. Ensure the submit button is enabled.
   * 7. Submit the form.
   * 8. Wait for the page transition to complete.
   * 9. Assert that the registration is successful by checking the URL.
   */
  it("should register in with valid credentials on iPhone-XR", () => {
    // Set the viewport to iPhone XR size
    cy.viewport("iphone-xr");

    // Visit the register page before each test
    cy.visit(Cypress.env("REGISTER_PAGE_URL"));

    // Get email, password, username, and full name from environment variables
    const emailText = Cypress.env("EMAIL");
    const passwordText = Cypress.env("PASSWORD");
    const usernameText = Cypress.env("USERNAME");
    const nameText = Cypress.env("NAME");

    // Button should be disabled.
    cy.get(".submitButton").should("be.disabled");

    cy.get("#email").clear();
    cy.get("#password").clear();
    cy.get("#username").clear();
    cy.get("#name").clear();

    // Fill the credentials.
    cy.get("#email").type(emailText, { force: true });
    cy.get("#password").type(passwordText, { force: true });
    cy.get("#username").type(usernameText, { force: true });
    cy.get("#name").type(nameText, { force: true });

    // Button should be enabled.
    cy.get(".submitButton").should("not.be.disabled");

    // Submit the form
    cy.get("#register").submit();

    // Wait for the page transition to complete
    cy.wait(1000);

    // Assert that the register is successful
    cy.url().should("include", Cypress.env("LOGIN_PAGE_URL"));
  });
});
