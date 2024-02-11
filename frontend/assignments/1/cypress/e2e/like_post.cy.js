/**
 * Visual testing for liking a post.
 * - Visits the specified page.
 * - Likes the first post.
 * - Compares the screenshot of the liked post.
 */
describe("Like Post", () => {
  /**
   * Function to post a tweet.
   * @param {string} tweetText - The text to be posted as a tweet.
   */
  const postTweet = (tweetText) => {
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
  };

  /**
   * Function to like a post.
   */
  const likePost = () => {
    // Ensure the posts container is visible in the viewport
    cy.get(".posts").should("be.visible");

    // Like the first post
    cy.get(".posts").children().first().find(".like-post").click();

    // Wait for the like to be processed
    cy.wait(2000);
  };

  /**
   * Function to compare the screenshot of the liked post.
   */
  const compareLikedPostSnapshot = () => {
    // Get the initial count of likes on the first post
    cy.get(".posts")
      .children()
      .first()
      .find(".likes-count")
      .invoke("text")
      .as("initialLikeCount");

    // Compare the screenshot of the liked post
    cy.get(".posts")
      .children()
      .first()
      .compareSnapshot("provided-liked-post", Cypress.env("TEST_THRESHOLD"));

    // Get the final count of likes on the first post after unliking
    cy.get(".posts")
      .children()
      .first()
      .find(".likes-count")
      .invoke("text")
      .as("updatedLikeCount");

    // Compare the initial and updated like counts to ensure they have increased
    cy.get("@initialLikeCount").then((initialCount) => {
      cy.get("@updatedLikeCount").should("be.gt", initialCount);
    });
  };

  /**
   * Function to unlike a post and compare the screenshot.
   */
  const unlikePostAndCompareSnapshot = () => {
    // Click the first liked post again to unlike it
    cy.get(".posts").children().first().find(".unlike-post").click();

    // Wait for the unlike to be processed (adjust as needed)
    cy.wait(2000);

    // Compare the screenshot of the post after unliking
    cy.get(".posts")
      .children()
      .first()
      .compareSnapshot("provided-unliked-post", Cypress.env("TEST_THRESHOLD"));

    // Get the final count of likes on the first post after unliking
    cy.get(".posts")
      .children()
      .first()
      .find(".likes-count")
      .invoke("text")
      .as("finalLikeCount");

    // Compare the initial and final like counts to ensure they are the same
    cy.get("@initialLikeCount").then((initialCount) => {
      cy.get("@finalLikeCount").should("eq", initialCount);
    });
  };

  /**
   * Test case to compare a screenshot after liking a post.
   */
  it("should compare screenshot after liking a post", () => {
    // Visit the specified page
    cy.visit(Cypress.env("HOME_PAGE_URL"));

    // Go with the size - Laptop (1079 x 726)
    cy.viewport(1079, 726);

    // Post a tweet
    postTweet(
      "Coffee in hand, bugs beware. Time to crush some code. #DeveloperLife #Coding"
    );

    // Like the post
    likePost();

    // Compare screenshots of liked post
    compareLikedPostSnapshot();

    // Unlike the post and compare screenshots
    unlikePostAndCompareSnapshot();
  });
});
