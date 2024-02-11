// JavaScript for tweet functionality
const tweetBtn = document.querySelector('.tweet-btn');
const postInput = document.querySelector('.post-input textarea');
const postsSection = document.querySelector('.posts');

tweetBtn.addEventListener('click', () => {
    const postContent = postInput.value;
    if (postContent.trim() !== '') {
        createPost(postContent);
        postInput.value = '';
    }
});

function createPost(content) {
    const post = document.createElement('div');
    post.classList.add('post');

    // Create post image div
    const postImage = document.createElement('div');
    postImage.classList.add('post-image');
    postImage.innerHTML = `
        <img class="img" src="./logo/propic.jpg" alt="profile picture">
    `;

    const postContentActions = document.createElement('div');
    postContentActions.classList.add('post-content-actions');

    const postTop = document.createElement('div');
    postTop.classList.add('post-top');

    const postMeta = document.createElement('div');
    postMeta.classList.add('post-meta');
    // postMeta.textContent = 'Nitesh Gupta @nit_hck · 1s';


    const postMetaOne = document.createElement('div');
    postMetaOne.classList.add('post-meta-one');
    postMetaOne.textContent = 'Nitesh Gupta';

    const postMetaTwo = document.createElement('div');
    postMetaTwo.classList.add('post-meta-two');
    postMetaTwo.textContent = '@nit_hck  · 1s';

    const postRight = document.createElement('div');
    postRight.classList.add('post-right');
    postRight.innerHTML = `
        <img class="img" src="./logo/postlogo/more.svg" alt="profile picture">
    `;
    
    const postContent = document.createElement('div');
    postContent.classList.add('post-content');
    postContent.innerHTML = `<p>${content}</p>`;

    const postActions3 = document.createElement('div');
    postActions3.classList.add('post-actions');
    postActions3.innerHTML = `<img class="img" src="./logo/postlogo/comment.svg" alt="profile picture">`;

    const postActions2 = document.createElement('div');
    postActions2.classList.add('post-actions');
    postActions2.innerHTML = `<img class="img" src="./logo/postlogo/retweet.svg" alt="profile picture">`;

    const postActions = document.createElement('div');
    postActions.classList.add('post-actions');
    postActions.innerHTML = `<button class="like-post"><img class="img" src="./logo/postlogo/like.svg" alt="profile picture"></button><span class="likes-count">0</span>`;
    


    const postActions4 = document.createElement('div');
    postActions4.classList.add('post-actions');
    postActions4.innerHTML = `<img class="img" src="./logo/postlogo/stats.svg" alt="profile picture">`;

    const postRightAction = document.createElement('div');
    postRightAction.classList.add('post-right-action');

    const postActions5 = document.createElement('div');
    postActions5.classList.add('post-actions');
    postActions5.innerHTML = `<img class="img" src="./logo/postlogo/save.svg" alt="profile picture">`;
    
    const postActions6 = document.createElement('div');
    postActions6.classList.add('post-actions');
    postActions6.innerHTML = `<img class="img" src="./logo/postlogo/upload.svg" alt="profile picture">`;
    

    const postActionsDiv = document.createElement('div');
    postActionsDiv.classList.add('post-actions-div');

    postMeta.appendChild(postMetaOne);
    postMeta.appendChild(postMetaTwo);

    postTop.appendChild(postMeta);
    postTop.appendChild(postRight);

    postRightAction.appendChild(postActions5);
    postRightAction.appendChild(postActions6);

    postActionsDiv.appendChild(postActions3);
    postActionsDiv.appendChild(postActions2);
    postActionsDiv.appendChild(postActions);
    postActionsDiv.appendChild(postActions4);
    postActionsDiv.appendChild(postRightAction);

    postContentActions.appendChild(postTop);
    postContentActions.appendChild(postContent);
    postContentActions.appendChild(postActionsDiv);

    post.appendChild(postImage);
    post.appendChild(postContentActions);
    postsSection.prepend(post);
    
    // Adding like functionality
    const likeBtn = post.querySelector('.like-post');
    likeBtn.addEventListener('click', () => {
        toggleLike(likeBtn);
    });
}

function toggleLike(btn) {
    btn.classList.toggle('liked');
    const likesCount = btn.nextElementSibling;

    likesCount.textContent = btn.classList.contains('liked') ? parseInt(likesCount.textContent) + 1 : parseInt(likesCount.textContent) - 1;
    // Change like count color to pink if liked
    likesCount.style.color = btn.classList.contains('liked') ? 'pink' : '';

}

// JavaScript for adding comments
const addCommentBtns = document.querySelectorAll('.add-comment-btn');

addCommentBtns.forEach(btn => {
    btn.addEventListener('click', () => {
        const commentInput = btn.previousElementSibling;
        const commentContent = commentInput.value;
        if (commentContent.trim() !== '') {
            const commentsList = btn.parentElement.previousElementSibling;
            addComment(commentsList, commentContent);
            commentInput.value = '';
        }
    });
});

function addComment(list, content) {
    const commentItem = document.createElement('li');
    commentItem.textContent = content;
    list.appendChild(commentItem);
}

// JavaScript for navigationSection functionality
// const postImageNav = document.querySelector('.post-image-nav');
// const navigationSection = document.querySelector('.navigation-section');

// postImageNav.addEventListener('click', () => {
//     navigationSection.classList.toggle('navigationSection-open'); // Toggle the class to open/close the navigationSection
// });

// JavaScript for navigationSection navigation
// document.addEventListener('DOMContentLoaded', function () {
//     const postImageNav = document.querySelector('.post-image-nav');
//     const sideNav = document.querySelector('.side-nav');

//     // Toggle side navigation when clicking on post-image-nav
//     postImageNav.addEventListener('click', function () {
//         sideNav.classList.toggle('active');
//     });

//     // Close side navigation when clicking outside of it
//     document.addEventListener('click', function (event) {
//         if (!sideNav.contains(event.target) && !postImageNav.contains(event.target)) {
//             sideNav.classList.remove('active');
//         }
//     });

//     // Prevent closing side navigation when clicking inside of it
//     sideNav.addEventListener('click', function (event) {
//         event.stopPropagation();
//     });
// });
// document.addEventListener('DOMContentLoaded', function () {
//     const postImageNav = document.querySelector('.post-image-nav');
//     const sideNav = document.querySelector('.navigation-section');

//     // Toggle side navigation when clicking on post-image-nav
//     postImageNav.addEventListener('click', function () {
//         sideNav.classList.toggle('open');
//     });

//     // Close side navigation when clicking outside of it
//     document.addEventListener('click', function (event) {
//         if (!sideNav.contains(event.target) && event.target !== postImageNav) {
//             sideNav.classList.remove('open');
//         }
//     });

//     // Prevent closing side navigation when clicking inside of it
//     sideNav.addEventListener('click', function (event) {
//         event.stopPropagation();
//     });
// });

// document.addEventListener('DOMContentLoaded', function () {
//     const profileIcon = document.querySelector('.profile-icon');
//     const navigationSection = document.querySelector('.navigation-section');

//     // Toggle navigationSection when clicking on profile icon
//     profileIcon.addEventListener('click', function () {
//         navigationSection.classList.toggle('open');
//     });

//     // Close navigationSection when clicking outside of it
//     document.addEventListener('click', function (event) {
//         if (!navigationSection.contains(event.target) && event.target !== profileIcon) {
//             navigationSection.classList.remove('open');
//         }
//     });

//     // Prevent closing navigationSection when clicking inside of it
//     navigationSection.addEventListener('click', function (event) {
//         event.stopPropagation();
//     });
// });

document.addEventListener('DOMContentLoaded', function () {
    const profileIcon = document.querySelector('.profile-icon');
    const navigationSection = document.querySelector('.navigation-section');

    // Toggle navigation section when clicking on profile icon
    profileIcon.addEventListener('click', function () {
        navigationSection.classList.toggle('open');
    });

    // Close navigation section when clicking outside of it
    document.addEventListener('click', function (event) {
        if (!navigationSection.contains(event.target) && event.target !== profileIcon) {
            navigationSection.classList.remove('open');
        }
    });

    // Prevent closing navigation section when clicking inside of it
    navigationSection.addEventListener('click', function (event) {
        event.stopPropagation();
    });
});
