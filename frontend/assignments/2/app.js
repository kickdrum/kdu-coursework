const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo = require("socket.io");
const path = require('path');

const users = require("./data/Users");
const twitterApi = require("./routes/api/twitter");

const app = express();
const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: "http://127.0.0.1:5501"
    }
});

app.use(cors());
app.use(express.json());
app.use("", twitterApi);
app.use('/node_modules', express.static(path.join(__dirname, 'node_modules')));
app.use(express.static('public'));

const connectedUsers = new Map();

io.on("connection", (socket) => {
    console.log("Connection created");

    socket.on('loggedin', function(user) {
        console.log("User logged in:", user.user_name);
        connectedUsers.set(socket.id, { id: user.id, user_name: user.user_name });
        updateUserList();
    });

    socket.on('privateMessage', (message) => {
        console.log("Received private message:", message); // Log the received message

        const { receiverUserId, text } = message;
        const receiverSocketId = Array.from(connectedUsers.entries())
            .find(([socketId, user]) => user.id === receiverUserId)?.[0];

        if (receiverSocketId) {
            // Emit the message only to the receiver
            io.to(receiverSocketId).emit('privateMessage', { sender: socket.id, text });
            // Optionally, you may also emit the message back to the sender
            io.to(socket.id).emit('privateMessage', { sender: socket.id, text });
        } else {
            // Handle error: Receiver not found
            console.log('Error: Receiver not found');
        }
    });

    socket.on('disconnect', () => {
        connectedUsers.delete(socket.id);
        updateUserList();
    });

    function updateUserList() {
        const users = Array.from(connectedUsers.values()).map(user => ({ id: user.id, user_name: user.user_name }));
        io.emit('userList', users);
    }
});

const PORT = process.env.PORT || 5000;
server.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});

app.use(express.static(path.join(__dirname, 'public')));
app.use(cors());
