// const express = require('express');
// const router = express.Router();
// const { v4: uuidv4 } = require('uuid'); // Import UUID module for generating unique IDs
// const fs = require('fs');

// // Sample posts data (you can replace this with your actual data or connect to a database)
// let posts = [];

// // API endpoint to fetch posts with pagination
// router.get('/api/posts', (req, res) => {
//     const { page = 1, limit = 5 } = req.query;

//     // Calculate start and end indices for pagination
//     const startIndex = (page - 1) * limit;
//     const endIndex = page * limit;

//     // Get paginated posts
//     const paginatedPosts = posts.slice(startIndex, endIndex);

//     res.json({ posts: paginatedPosts });
// });

// // API endpoint to create a new post
// router.post('/api/posts', (req, res) => {
//     const { content } = req.body;
//     const media = req.files?.media; // Assuming multipart/form-data with file upload

//     // Validate request data
//     if (!content || content.trim() === '') {
//         return res.status(400).json({ message: 'Post content is required' });
//     }

//     // Create new post object
//     const newPost = {
//         id: uuidv4(), // Generate unique ID for the post
//         content,
//         media: media ? media.name : null // Store media filename or null if no media uploaded
//     };

//     // Save media file if uploaded
//     if (media) {
//         const filePath = `uploads/${media.name}`;
//         media.mv(filePath, (err) => {
//             if (err) {
//                 console.error('Error saving media file:', err);
//                 return res.status(500).json({ message: 'Failed to save media file' });
//             }
//         });
//     }

//     // Add new post to the beginning of the posts array
//     posts.unshift(newPost);

//     res.status(201).json({ message: 'Post created successfully', post: newPost });
// });

// module.exports = router;
