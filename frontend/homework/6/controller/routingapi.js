const express = require('express');
const uuid = require('uuid');
const getPosts = require('../postdata/posts');
const { log } = require('console');

const router = express.Router();

// Retrieve all posts.
router.get("/", (req, res) => {
    res.status(200).json(getPosts);
});

//Create a new post.

router.post("/", (req, res) => {
    let { userId, content } = req.body;
    let id = uuid.v4();
    let createPost = { id, userId, content };
    getPosts.push(createPost);
    res.status(201).json(createPost);
});

// Retrieve a post by its unique identifier (ID
router.get("/:id", (req, res) => {
    let requestId = req.params.id;
    let post = getPosts.filter((x) => x.id === requestId);
    if(!post.length){
        res.status(404).json({
            "message":"No data available",
            "status code":"404",
            "Error":"post list empty"
        });
    } else {
        res.status(200).json(post);
    }
});

module.exports = router;
