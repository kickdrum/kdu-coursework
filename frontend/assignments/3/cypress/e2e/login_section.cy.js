/**
 * Cypress Test: Login Page Visual Regression
 *
 * Description:
 * This Cypress test visits the login page of the application, takes a full-page screenshot,
 * and compares it with a baseline image using visual regression testing. The test ensures
 * that the login page's visual appearance remains consistent over time.
 */
describe("Login Page Visual Regression", () => {
  /**
   * Test Case: Match Baseline Screenshot on Desktop
   *
   * Test Steps:
   * 1. Visit the login page of the application.
   * 2. Take a full-page screenshot of the login page.
   * 3. Compare the screenshot with a baseline image using visual regression testing.
   *
   * Error Threshold:
   * A maximum error threshold of TEST_THRESHOLD is set, allowing for a 20% difference between
   * the captured screenshot and the baseline image.
   */
  it("should match baseline screenshot on desktop", () => {
    // Visit the login page
    cy.visit(Cypress.env("LOGIN_PAGE_URL"));

    // Take a full-page screenshot
    cy.screenshot("loginPage", { capture: "fullPage" });

    // Compare the screenshot with a baseline image
    // Error threshold set to TEST_THRESHOLD (20% difference)
    cy.compareSnapshot("loginPage", Cypress.env("TEST_THRESHOLD"));
  });

  /**
   * Test Case: Match Baseline Screenshot on iPhone XR
   *
   * Test Steps:
   * 1. Set the viewport to iPhone XR size.
   * 2. Visit the login page of the application.
   * 3. Take a full-page screenshot of the login page.
   * 4. Compare the screenshot with a baseline image using visual regression testing.
   *
   * Error Threshold:
   * A maximum error threshold of TEST_THRESHOLD is set, allowing for a 20% difference between
   * the captured screenshot and the baseline image.
   */
  it("should match baseline screenshot on iPhone XR", () => {
    // Set the viewport to iPhone XR size
    cy.viewport("iphone-xr");

    // Visit the login page
    cy.visit(Cypress.env("LOGIN_PAGE_URL"));

    // Take a full-page screenshot
    cy.screenshot("loginPageiPhoneXR", { capture: "fullPage" });

    // Compare the screenshot with a baseline image
    // Error threshold set to TEST_THRESHOLD (20% difference)
    cy.compareSnapshot("loginPageiPhoneXR", Cypress.env("TEST_THRESHOLD"));
  });

  /**
   * Test Case: Log in with Valid Credentials on Desktop
   *
   * Test Steps:
   * 1. Change viewport to macbook-16.
   * 2. Visit the login page of the application.
   * 3. Get email and password from environment variables.
   * 4. Ensure the submit button is initially disabled.
   * 5. Clear input fields.
   * 6. Fill in the credentials.
   * 7. Ensure the submit button is enabled.
   * 8. Submit the form.
   * 9. Wait for the page transition to complete.
   * 10. Assert that the login is successful by checking the URL.
   */
  it("should log in with valid credentials on desktop", () => {
    // Change viewport to macbook-16
    cy.viewport("macbook-16");

    // Visit the login page
    cy.visit(Cypress.env("LOGIN_PAGE_URL"));

    // Get email and password from environment variables
    const emailText = Cypress.env("EMAIL");
    const passwordText = Cypress.env("PASSWORD");

    // Button should be disabled.
    cy.get(".submitButton").should("be.disabled");

    // Clear the input fields
    cy.get("#email").clear();
    cy.get("#password").clear();

    // Fill the credentials.
    cy.get("#email").type(emailText);
    cy.get("#password").type(passwordText);

    // Button should be enabled after filling the credentials.
    cy.get(".submitButton").should("not.be.disabled");

    // Submit the form
    cy.get("#login").submit();

    // Wait for the page transition to complete
    cy.wait(1000);

    // Assert that the login is successful
    cy.url().should("include", Cypress.env("HOME_PAGE_URL"));
  });

  /**
   * Test Case: Log in with Valid Credentials on iPhone XR
   *
   * Test Steps:
   * 1. Change viewport to iPhone XR.
   * 2. Visit the login page of the application.
   * 3. Get email and password from environment variables.
   * 4. Ensure the submit button is initially disabled.
   * 5. Clear input fields.
   * 6. Fill in the credentials.
   * 7. Ensure the submit button is enabled.
   * 8. Submit the form.
   * 9. Wait for the page transition to complete.
   * 10. Assert that the login is successful by checking the URL.
   */
  it("should log in with valid credentials on iPhone XR", () => {
    // Change viewport to iPhone XR
    cy.viewport("iphone-xr");

    // Visit the login page
    cy.visit(Cypress.env("LOGIN_PAGE_URL"));

    // Get email and password from environment variables
    const emailText = Cypress.env("EMAIL");
    const passwordText = Cypress.env("PASSWORD");

    // Button should be disabled.
    cy.get(".submitButton").should("be.disabled");

    // Clear the input fields
    cy.get("#email").clear();
    cy.get("#password").clear();

    // Fill the credentials.
    cy.get("#email").type(emailText);
    cy.get("#password").type(passwordText);

    // Button should be enabled after filling the credentials.
    cy.get(".submitButton").should("not.be.disabled");

    // Submit the form
    cy.get("#login").submit();

    // Wait for the page transition to complete
    cy.wait(1000);

    // Assert that the login is successful
    cy.url().should("include", Cypress.env("HOME_PAGE_URL"));
  });
});
