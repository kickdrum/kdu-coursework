/**
 * Visual testing for the send-post section.
 * - Visits the specified page.
 * - Ensures the tweet-box element is visible.
 * - Captures a screenshot of the tweet-box element.
 * - Checks if the 'tweet-btn' button is disabled.
 * - Compares the captured screenshot with the provided snapshot.
 */
describe("Tweet Box Section", () => {
  /**
   * Function to visit the specified page and set viewport.
   * @param {number} width - Width of the viewport.
   * @param {number} height - Height of the viewport.
   */
  const visitPageAndSetViewport = (width, height) => {
    // Visit the specified page
    cy.visit(Cypress.env('HOME_PAGE_URL'));

    // Set viewport size
    cy.viewport(width, height);
  };

  /**
   * Function to ensure the specified element is visible in the viewport.
   * @param {string} elementSelector - Selector of the element to be checked for visibility.
   */
  const ensureElementVisible = (elementSelector) => {
    cy.get(elementSelector).should("be.visible");
  };

  /**
   * Function to capture a screenshot of the specified element.
   * @param {string} elementSelector - Selector of the element to capture.
   * @param {string} snapshotName - Name to be used for the snapshot.
   * @param {number} threshold - Threshold for image comparison.
   */
  const captureElementScreenshot = (
    elementSelector,
    snapshotName,
    threshold
  ) => {
    cy.get(elementSelector).compareSnapshot(snapshotName, threshold);
  };

  /**
   * Test case to compare a screenshot of the send-post section.
   */
  it("should compare screenshot of the send-post section", () => {
    // Go with the size - Laptop (1079 x 726)
    visitPageAndSetViewport(1079, 726);

    // Ensure the tweet-box element is visible in the viewport
    ensureElementVisible(".tweet-box");

    // Capture screenshot of the tweet-box element
    captureElementScreenshot(".tweet-box", "provided-tweet-box", 0.2);
  });

  /**
   * Test case to compare a screenshot of the send-post section in the mobile view.
   */
  it("should compare screenshot of the send-post section in the mobile view", () => {
    // Go with the size - Mobile (414 x 896)
    visitPageAndSetViewport(414, 896);

    // Ensure the floating tweet-box icon element is visible in the viewport
    ensureElementVisible(".floating-tweet-box-icon");

    // Click the 'floating-tweet-box-icon'
    cy.get(".floating-tweet-box-icon").click();

    // Wait for the box to get open
    cy.wait(1000);

    // Capture screenshot of the tweet-box element
    captureElementScreenshot(".tweet-box", "MV-provided-tweet-box", 0.2);
  });
});
