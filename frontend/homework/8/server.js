const express = require('express');
const socketio = require('socket.io');
const http = require('http');
const messageObject = require('./Mapper.js')

const app = express();
const server = http.createServer(app);
const io = socketio(server);
const PORT = 8000;



// my bot name
const botname = "Server";

// random usernames list
const usernameList = ["virat", "rohit", "bumrah"];

// variable index to keep iterator on usernamesList
let index = 0;


// when client is connected
io.on("connection", (socket)=>{

    // generating random username
    const username = usernameList[index];
    index++;

    // printing connection message on server's console
    console.log(`${username} connected`);

    // when client sends message
    socket.on('chatMessage', (message)=>{

        // creating messageObject {id, username, message}
        let msgObject = messageObject(socket.id, username, message);

        // printing client's message on server's console
        console.log(`New message from ${msgObject.username}: ${msgObject.message}`);
        
        // broadcasting client's message
        io.emit('chatMessage', msgObject);

    })

    // when client leaves 
    socket.on('disconnect', ()=>{

        // creating custom disconnect message
        let disconnectMessage = `${username} disconnected`;

        // creating messageObject {id, username, disconnectMessage}
        let msgObject = messageObject(socket.id, botname, disconnectMessage);

        // printing on server's console
        console.log(disconnectMessage);

        // broadcasting disconnectMessage
        io.emit('chatMessage', msgObject);
    })
})


// listening server
server.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`)
});