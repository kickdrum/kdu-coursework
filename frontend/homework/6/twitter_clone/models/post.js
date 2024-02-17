
let posts = [];

function createPost(post) {
  post.id = posts.length + 1;
  posts.push(post);
  return post;
}

function getPostById(id) {
  return posts.find((post) => post.id === id);
}

function getAllPosts() {
  return posts;
}

module.exports = { createPost, getPostById, getAllPosts };
