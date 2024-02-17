let users = [ ];

function registerUser(user) {
  user.id = users.length + 1;
  users.push(user);
  return user;
}

function getUserByUsername(username) {
  return users.find((user) => user.username === username);
}

module.exports = { registerUser, getUserByUsername };
