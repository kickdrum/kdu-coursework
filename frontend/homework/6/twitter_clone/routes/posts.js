// twitter_clone/routes/post.js
const express = require("express");
const router = express.Router();
const { createPost, getPostById, getAllPosts } = require("../models/post");

// POST /posts
router.post("/", (req, res) => {
  const post = createPost(req.body);
  res.status(201).json(post);
});

// GET /posts/:id
router.get("/:id", (req, res) => {
  const post = getPostById(parseInt(req.params.id));
  if (post) {
    res.json(post);
  } else {
    res.status(404).send("Post not found");
  }
});

// GET /posts
router.get("/", (req, res) => {
  res.json(getAllPosts());
});

// Export the router
module.exports = router;
