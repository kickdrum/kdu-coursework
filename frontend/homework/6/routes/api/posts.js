const express = require('express');
const posts=require("../../data/Posts");

const router = express.Router();
router.get("/posts",(req,res)=>{
    res.json({
        data:posts,
    });
});

router.post("/post",(req,res)=>{
    const post={
        id: posts.length+1,
        name:req.body.name
    }
    posts.push(post);
    res.status(201).json(post);
})

router.get("/post/:id",(req,res)=>{
    const search_id=req.params.id;
    const post=posts.filter((x)=>x.id===parseInt(search_id));

    if(post.length===0){
        res.status(404).json({
            "message":"Postrs with id not found"
        })
    }
    res.json(post[0]);
})

module.exports=router;
