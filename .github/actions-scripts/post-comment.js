const axios = require("axios");

// log all the env variables
console.log(
  `PERSONAL_ACCESS_TOKEN_GITHUB: ${process.env.PERSONAL_ACCESS_TOKEN_GITHUB}`
);
console.log(`SONAR_TOKEN: ${process.env.SONAR_TOKEN}`);
console.log(`SONAR_HOST_URL: ${process.env.SONAR_HOST_URL}`);
console.log(`SONAR_PROJECT_KEY: ${process.env.SONAR_PROJECT_KEY}`);
console.log(`USERNAME_GITHUB: ${process.env.USERNAME_GITHUB}`);
console.log(`REPO_NAME_GITHUB: ${process.env.REPO_NAME_GITHUB}`);
console.log(`PULL_REQUEST_NUMBER: ${process.env.PULL_REQUEST_NUMBER}`);

// SonarQube API details
const sonarqubeURL = `${process.env.SONAR_HOST_URL}/api`;
const measuresEndpoint = `${sonarqubeURL}/measures/search`;

// SonarQube project and metrics details
const projectKey = process.env.SONAR_PROJECT_KEY;
const metricKeys = [
  "alert_status",
  "bugs",
  "code_smells",
  "vulnerabilities",
  "reliability_rating",
  "security_rating",
  // Add more metric keys as needed
];

// SonarQube authentication token
const sonarToken = process.env.SONAR_TOKEN;

// GitHub repository details
const owner = process.env.USERNAME_GITHUB;
const repo = process.env.REPO_NAME_GITHUB;
const issueNumber = process.env.PULL_REQUEST_NUMBER;

// Personal access token with appropriate permissions
const gitHubAccessToken = process.env.PERSONAL_ACCESS_TOKEN_GITHUB;

// Function to create a comment with a table of metrics on a GitHub issue
async function createCommentWithMetricsTable(metrics) {
  // format metrics as a table
  const tableHeader = "| Metric | Value |\n| ------ | ----- |";
  const tableRows = metrics
    .map(
      (metric) =>
        `| ${metric.key} | ${getMetricValue(metric.key, metric.value)} |`
    )
    .join("\n");

  const commentBody = `${tableHeader}\n${tableRows}`;

  // Create a comment on the GitHub issue
  const apiUrl = `https://api.github.com/repos/${owner}/${repo}/issues/${issueNumber}/comments`;

  // Axios configuration
  const axiosConfig = {
    headers: {
      Authorization: `Bearer ${gitHubAccessToken}`,
      Accept: "application/vnd.github.v3+json",
      "X-GitHub-Api-Version": "2022-11-28",
    },
  };

  try {
    const response = await axios.post(
      apiUrl,
      { body: commentBody },
      axiosConfig
    );
    console.log("Comment created successfully:", response.data);
  } catch (error) {
    console.error(
      "Error creating comment:",
      error?.response?.data || error.message
    );
    throw error;
  }
}

function getMetricValue(key, value) {
  let returnValue = value;
  switch (key) {
    case `reliability_rating`:
      switch (value + "") {
        case "1.0":
          returnValue = "A (0 Bugs)";
          break;
        case "2.0":
          returnValue = "B (at least 1 Minor Bug)";
          break;
        case "3.0":
          returnValue = "C (at least 1 Major Bug)";
          break;
        case "4.0":
          returnValue = "D (at least 1 Critical Bug)";
          break;
        case "5.0":
          returnValue = "E (at least 1 Blocker Bug)";
          break;

        default:
          break;
      }
      returnValue = returnValue + "<br/>Note: A being best, E being worst";
      break;
    case `security_rating`:
      switch (value + "") {
        case "1.0":
          returnValue = "A (0 Vulnerabilities)";
          break;
        case "2.0":
          returnValue = "B (at least 1 Minor Vulnerability)";
          break;
        case "3.0":
          returnValue = "C (at least 1 Major Vulnerability)";
          break;
        case "4.0":
          returnValue = "D (at least 1 Critical Vulnerability)";
          break;
        case "5.0":
          returnValue = "E (at least 1 Blocker Vulnerability)";
          break;

        default:
          break;
      }
      returnValue = returnValue + "<br/>Note: A being best, E being worst";
      break;
    case `alert_status`:
      switch (value) {
        case "OK":
          returnValue = `<b>:white_check_mark: ${value}</b>`;
          break;
        case "ERROR":
          returnValue = `<b>:x: ${value}</b>`;
          break;

        default:
          returnValue = `<b>:warning: ${value}</b>`;
          break;
      }
      break;

    default:
      break;
  }
  return returnValue;
}

// Function to fetch metrics data from SonarQube API
async function fetchMetricsData() {
  const params = {
    projectKeys: projectKey,
    metricKeys: metricKeys.join(),
  };

  const axiosConfig = {
    headers: {
      Authorization: `Bearer ${sonarToken}`, // Set SonarQube token in the headers
    },
  };

  try {
    const response = await axios.get(measuresEndpoint, {
      params,
      ...axiosConfig,
    });
    const metrics = response.data.measures.map((metric) => ({
      key: metric.metric,
      value: metric.value,
    }));
    await createCommentWithMetricsTable(metrics);
  } catch (error) {
    console.error(
      "Error fetching metrics data:",
      error?.response?.data || error.message
    );
    throw error;
  }
}

// Call the function to fetch metrics data and create a comment with the metrics table
fetchMetricsData();