const express = require('express');
const socketio = require('socket.io');
const cors = require("cors");
const Socket = require("socket.io");
const http = require('http');
const messageObject = require('./Mapper.js');
const moment = require('moment');

const PORT = 5000;


const app = express();
const server = http.createServer(app);


const io = Socket(server, {
    cors: {
        origin: "*",
        methods: ["GET", "POST"],
    },
});


// my bot name
const botname = "Server";

app.use(
    cors({
        origin: ["http://localhost:5500"],
        credentials: true,
    })
);


// when client is connected
io.on("connection", (socket) => {

    const id = socket.id;

    // printing connection message on server's console
    console.log(`${id} connected (${moment().format('h:mm:ss a')})`);


    socket.on("joinRoom", (roomName) => {

        socket.join(roomName);

        // Welcome current user
        console.log(`Welcome ${id} to room: ${roomName}`);

    });



    // when client sends message
    socket.on('chatMessage', (message, roomName) => {

        console.log(message, roomName);

        // creating messageObject {id, message}
        let msgObject = messageObject(socket.id, roomName, message);

        // printing client's message on server's console
        console.log(`New message from ${msgObject.id} in ${msgObject.roomName} (${msgObject.time}): ${msgObject.message}`);

        // broadcasting client's message
        io.to(roomName).emit('chatMessage', msgObject);
    })

    // when client leaves 
    socket.on('disconnect', () => {

        // creating custom disconnect message
        let disconnectMessage = `${id} disconnected`;

        // creating messageObject {id, username, disconnectMessage}
        let msgObject = messageObject(socket.id, "", disconnectMessage);

        // printing on server's console
        console.log(disconnectMessage + `(${msgObject.time})`);

        // broadcasting disconnectMessage
        // io.emit('chatMessage', msgObject);
    })
})


// listening server
server.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`)
});