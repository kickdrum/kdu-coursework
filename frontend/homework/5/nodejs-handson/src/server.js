// importing the modules
const http = require("http");
const fs = require("fs");
const path = require("path");

// Create an HTTP server
http
  .createServer((req, res) => {
    if (req.url === "/") {
      // Define the path to the system information JSON file
      const jsonPath = path.join(__dirname, "systemInfo.json");
      // Read the system information from the file
      fs.readFile(jsonPath, "utf8", (err, data) => {
        if (err) {
          res.writeHead(500);
          res.end("Error reading system information");
          return;
        }
        res.writeHead(200, { "Content-Type": "application/json" });
        res.end(data);
      });
    } else {
      res.writeHead(404);
      res.end("Not Found");
    }
  })
  .listen(3000, () => console.log("Server running on http://localhost:3000/"));
