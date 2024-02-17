document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.getElementById("login-form");
  const registerForm = document.getElementById("register-form");
  const postForm = document.getElementById("post-form");
  const loginSection = document.getElementById("login-section");
  const registerSection = document.getElementById("register-section");
  const findPostSection = document.getElementById("find-post-section"); 
  const postsSection = document.getElementById("post-section");
  const findPostForm = document.getElementById("find-post-form"); 

  // Initially hide post and find post sections
  postsSection.style.display = "none";
  findPostSection.style.display = "none";

  // Handle login form submission
  loginForm.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
    const username = document.getElementById("login-username").value;
    const password = document.getElementById("login-password").value;

    // Attempt to login
    fetch("/users/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    })
      .then((response) => {
        if (response.ok) {
          loginSection.style.display = "none";
          registerSection.style.display = "none";
          postsSection.style.display = "block";
          findPostSection.style.display = "block"; // Show find post section upon successful login
          fetchAndDisplayPosts(); // Fetch and display posts upon successful login
          return response.json();
        }
        throw new Error("Failed to login");
      })
      .then((data) => {
        alert("Login successful");
      })
      .catch((error) => {
        console.error("Error:", error);
        alert(error.message);
      });
  });

  // Handle registration form submission
  registerForm.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent default form submission
    const username = document.getElementById("register-username").value;
    const password = document.getElementById("register-password").value;

    // Attempt to register
    fetch("/users/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    })
      .then((response) => {
        if (response.ok) {
          alert("Registration successful");
          return response.json();
        }
        throw new Error("Username already exists or failed to register");
      })
      .catch((error) => {
        console.error("Error:", error);
        alert(error.message);
      });
  });

  // Handle post submission
  postForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const content = document.getElementById("post-content").value;

    // Attempt to submit a post
    fetch("/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ content }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Post added:", data);
        fetchAndDisplayPosts(); // Refresh the posts display
      })
      .catch((error) => {
        console.error("Error adding post:", error);
      });
  });

  // Function to fetch and display posts
  function fetchAndDisplayPosts() {
    fetch("/posts")
      .then((response) => response.json())
      .then((posts) => {
        const postsContainer = document.getElementById("posts-container");
        postsContainer.innerHTML = ""; // Clear previous posts
        posts.forEach((post) => {
          const postElement = document.createElement("div");
          postElement.className = "post";

          const postContent = document.createElement("p");
          postContent.textContent = post.content;

          postElement.appendChild(postContent);

          postsContainer.appendChild(postElement);
        });
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }

  // Handle find post form submission
  findPostForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const postId = document.getElementById("find-post-id").value;

    fetch(`/posts/${postId}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Post not found");
        }
        return response.json();
      })
      .then((post) => {
        const foundPostContainer = document.getElementById(
          "found-post-container"
        );
        foundPostContainer.innerHTML = ""; // Clear previous results
        const postElement = document.createElement("div");
        postElement.innerHTML = `<h3>Post ID: ${post.id}</h3><p>${post.content}</p>`;
        foundPostContainer.appendChild(postElement);
      })
      .catch((error) => {
        console.error("Error:", error);
        alert(error.message);
      });
  });
});
