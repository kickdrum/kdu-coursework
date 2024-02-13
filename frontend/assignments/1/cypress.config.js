const { defineConfig } = require("cypress");
const getCompareSnapshotsPlugin = require("cypress-visual-regression/dist/plugin");

// Export Cypress configuration using defineConfig function
module.exports = defineConfig({
  // Trash assets (screenshots, videos) before each test run
  // screenshotsFolder : "cypress/screenshots",
  trashAssetsBeforeRuns: true,

  // Disable video recording during test runs
  video: false,

  // Configuration for end-to-end (e2e) tests
  e2e: {
    // Base URL for your application
    baseUrl: "http://localhost:5500/assignments/1",

    // Setup Node events for visual regression testing using cypress-visual-regression plugin
    setupNodeEvents(on, config) {
      // Integrate the compareSnapshots plugin into Cypress
      getCompareSnapshotsPlugin(on, config);
    },
  },
  // Environment variables
  env: {
    EMAIL: "test@gmail.com",
    PASSWORD: "test",
    USERNAME: "test-user",
    NAME: "test-name",
    HOME_PAGE_URL: "/home-page/index.html",
    LOGIN_PAGE_URL: "login/index.html",
    REGISTER_PAGE_URL: "/register/index.html",
    TEST_THRESHOLD: 0.35,
  },
});
