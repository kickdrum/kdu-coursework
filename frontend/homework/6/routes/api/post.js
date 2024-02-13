const posts = require('../../data/posts')
const express = require('express')
const router = express.Router();

router.get('/all', (req,res) => {
    res.json(posts);
})

router.get('/:id', (req, res) => {
    const postId = req.params.id;

    const post = posts.find(post => post.id === postId);

    if (post) {
        res.json(post);
    } else {
        res.status(404).json({ error: 'Post not found' });
    }
});

const uuid = require('uuid')

router.post('/', (req, res) => {
    const { name, email, content } = req.body;

    const postId = uuid.v4();

    const newPost = {
        id: postId,
        name,
        email,
        content
    };

    posts.push(newPost);

    res.status(201).json(newPost);
});

module.exports = router