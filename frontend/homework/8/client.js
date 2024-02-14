const readline = require("readline");
const io = require("socket.io-client");

// creating socket to listen server
const socket = io("http://localhost:8000");


// creating readline instance
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});


// Handle terminal input
rl.on("line", (input) => {

    // sending client's message to server --> so that it can be broadcasted
    socket.emit("chatMessage", input);
});


// listening broadcasted message from server
socket.on("chatMessage", (msgObject) => {
    console.log(`Message received from ${msgObject.username}: ${msgObject.message}`);
});
