const moment = require('moment');

// standard message object with user-id, user-name and message
const messageObject = (id, roomName, message) => {
    return {
        id,
        roomName,
        message,
        time: moment().format('h:mm:ss a')
    };
}

module.exports = messageObject;