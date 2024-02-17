const express = require("express");
const cors = require("cors"); 
const app = express();
const port = 3000;



app.use(cors());

// Middleware for parsing request bodies
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Serve static files from public
app.use(express.static("public"));

// Routes
app.use("/users", require("./routes/users"));
app.use("/posts", require("./routes/posts"));

// Start the server
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
