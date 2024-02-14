// standard message object with user-id, user-name and message
const messageObject = (id, username, message) => {
    return {
        id,
        username,
        message
    };
}

module.exports = messageObject;