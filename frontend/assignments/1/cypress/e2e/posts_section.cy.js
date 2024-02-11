/**
 * Visual testing for the send-post section.
 * - Visits the specified page.
 * - Enters text in the tweet-box.
 * - Clicks the 'tweet-btn' button.
 * - Compares the screenshot of the first element with class 'posts.'
 */
describe("Posts Section", () => {
  /**
   * Function to post a tweet and compare the screenshot.
   * @param {number} viewportWidth - The viewport width.
   * @param {number} viewportHeight - The viewport height.
   * @param {string} tweetText - The text to be posted as a tweet.
   * @param {string} snapshotName - The name for the snapshot.
   */
  const postTweetAndCompareSnapshot = (
    viewportWidth,
    viewportHeight,
    tweetText,
    snapshotName
  ) => {
    // Visit the specified page
    cy.visit(Cypress.env("HOME_PAGE_URL"));

    // Set the viewport size
    cy.viewport(viewportWidth, viewportHeight);

    // Ensure the tweet-box element is visible in the viewport
    cy.get(".tweet-box").should("be.visible");

    // Type text in the tweet-box
    cy.get(".post-input").type(tweetText);

    // Check if the 'tweet-btn' button is enabled
    cy.get("#tweet-btn").should("not.be.disabled");

    // Click the 'tweet-btn' button
    cy.get("#tweet-btn").click();

    // Wait for the tweet to be posted
    cy.wait(2000);

    // Compare the screenshot of the first element with class 'posts'
    cy.get(".posts")
      .children()
      .first()
      .compareSnapshot(snapshotName, Cypress.env("TEST_THRESHOLD"));
  };

  /**
   * Test case to compare a screenshot after posting a tweet.
   */
  it("should compare screenshot after posting a tweet", () => {
    postTweetAndCompareSnapshot(
      1079,
      726,
      "Coffee in hand, bugs beware. Time to crush some code. #DeveloperLife #Coding",
      "provided-post"
    );
  });

  /**
   * Test case to compare a screenshot after posting a tweet in the mobile view.
   */
  it("should compare screenshot after posting a tweet in the mobile view", () => {
    postTweetAndCompareSnapshot(
      414,
      896,
      "Coffee in hand, bugs beware. Time to crush some code. #DeveloperLife #Coding",
      "MV-provided-post"
    );
  });
});
