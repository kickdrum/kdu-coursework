//importing modules from twitter_clone/models/user and express
const express = require("express");
const router = express.Router();
const { registerUser, getUserByUsername } = require("../models/user");


//POST /users/register
router.post("/register", (req, res) => {
    console.log("register api called");
  if (getUserByUsername(req.body.username)) {
    return res.status(400).send("Username already exists");
  }
  const user = registerUser(req.body);
  res.status(201).json(user);
});


//POST /users/login
router.post("/login", (req, res) => {
  const user = getUserByUsername(req.body.username);
  if (!user) {
    return res.status(404).send("User not found");
  }

  if (user.password === req.body.password) {
    res.status(200).json({ message: "Login successful", user });
  } else {
    res.status(401).send("Invalid credentials");
  }
});

// Export the router
module.exports = router;
