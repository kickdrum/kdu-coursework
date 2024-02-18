const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo = require("socket.io");
let bodyparser  = require('body-parser');
const path      = require('path');



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
app.use(bodyparser.json())
app.use('/node_modules', express.static(path.join(__dirname, 'node_modules', )));
app.use(express.static('public'));

const userSockets = new Map();

let clientSocketIds = [];
let connectedUsers= [];

const getSocketByUserId = (userId) =>{
    let socket = clientSocketIds[1].socket; //hardcoded default value
    // console.log("clientSocketIds here:->",clientSocketIds, clientSocketIds.length, userId);
    for(let i = 0; i<clientSocketIds.length; i++) {
        console.log("till finding:",clientSocketIds[i].userId, userId);
        if(clientSocketIds[i].userId == userId) { //idk why if statement is not working
            console.log('ayyo ith id:',clientSocketIds[i]);
            socket = clientSocketIds[i].socket;
            break;
        }
    }
    return socket;
}

io.on("connection", (socket) => {
    console.log("Connection created");

    socket.on('loggedin', function(user) {
        console.log("login check");
        clientSocketIds.push({socket: socket, userId:  user.id});
        // console.log(clientSocketIds);
        connectedUsers = connectedUsers.filter(item => item.id != user.id);
        connectedUsers.push({...user, socketId: socket.id})
        console.log(connectedUsers);

        // io.emit('updateUserList', connectedUsers);
        socket.broadcast.emit('updateUserList', connectedUsers);
        console.log("pata nhi test2");

    });

   

    socket.on('create', function(data) {
        console.log("create room", data.room, data.withUserId)
        
        socket.join(data.room);
        let withSocket = getSocketByUserId(data.withUserId);
        console.log(withSocket.id,);
        socket.broadcast.to(withSocket.id).emit("invite",{room:data})
    });
    
    socket.on('joinRoom', function(data) {
        socket.join(data.room.room);
    });

    socket.on('message', function(data) {
        socket.broadcast.to(data.room).emit('message', data);
    })
});

server.listen(5000, () => {
    console.log("Application started on port 5000");
});
