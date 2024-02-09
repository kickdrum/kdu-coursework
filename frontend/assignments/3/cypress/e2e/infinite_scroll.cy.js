describe("Infinite Scroll Test", () => {
  const EXPECTED_INTERCEPTION_COUNT = 5;

  const interceptPaginatedPosts = () => {
    cy.intercept("GET", "**/api/post/paginated-posts*", (req) => {
      req.alias = "paginatedPosts"; // Use a static alias
      req.continue();
    });
  };

  const scrollAndWaitForPaginatedPosts = () => {
    cy.scrollTo("bottom");
    // Wait for the intercepted request to complete
    cy.wait("@paginatedPosts").then((interception) => {
      // Extract page size from the URL
      const pageSize = Number(
        interception.request.url.match(/pageSize=(\d+)/)[1]
      );
      const pageNumber = Number(
        interception.request.url.match(/pageNumber=(\d+)/)[1]
      );

      // Assert the number of posts in the DOM
      cy.get(".posts")
        .children()
        .should("have.length", pageSize * pageNumber);

      // Wait for a short duration
      cy.wait(2000);
    });
  };

  it("should intercept paginated-posts API calls while scrolling", () => {
    // Visit your application
    cy.visit(Cypress.env('HOME_PAGE_URL'));

    cy.viewport(1079,726);

    // Intercept paginated posts for the initial page load
    interceptPaginatedPosts();

    // Scroll to the bottom multiple times
    for (let i = 0; i < EXPECTED_INTERCEPTION_COUNT; i++) {
      // Scroll to a specific position
      scrollAndWaitForPaginatedPosts();
    }
  });
});
