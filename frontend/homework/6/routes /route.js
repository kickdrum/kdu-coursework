const express = require("express")
const router =express.Router()
const posts = require("../data/posts");
const uuid = require('uuid')
router.use(express.json());

router.get('/', async(req,res) =>{
   try{
res.json({
    data:posts
})
   }catch(err){
    res.status('Error'+ err);
   }
})


router.post('/user', async (req, res) => {
    try {
        const { name, content } = req.body;
        if (!name || !content) {
            return res.status(400).json({ error: 'Name and content are required' });
        }

        const user = {
            id: uuid.v4(),
            name: name,
            content: content
        };

        posts.push(user);
        res.status(201).json(user);
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Internal Server Error' });
    }
});

router.get('/:id', async (req, res) => {
    try {
        const postId = parseInt(req.params.id);
        const post = posts.find(post => post.id === postId);
        
        if (!post) {
            res.status(404).json({ error: 'Post not found' });
            return;
        }
        
        res.json({ data: post });
    } catch (err) {
        res.status(500).json({ error: 'wrong input provided ' });
    }
});







module.exports = router;