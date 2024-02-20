const express = require("express");
const http = require("http");
const cors = require("cors");
const socketIo= require('socket.io');

const app = express();
app.use(cors());
app.use(express.json());
const server = http.createServer(app);


const io= new socketIo.Server(server,{
    cors:{
        origin:"*"
    }
})

io.on("connection", socket =>{
    console.log("connection built");


    socket.on('ping', x =>{
        io.emit('ping',x);
        console.log("aaaaaaaaaa" + x);
    })


    socket.on('activity', qty =>{
        io.emit('activity', qty);
        console.log(qty);
    })

    
});

const PORT = 3003;
server.listen(PORT, () =>{
    console.log("server is running", PORT);
})