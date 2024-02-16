const express =require("express");
const http = require("http");
const cors = require("cors");
const socketIO =require('socket.io');
const app =express();
const server=http.createServer(app);

app.use(cors());


app.use(express.json());
const io =new socketIO.Server(server,{
    cors:{
        origin:"http://127.0.0.1:5500"
    }
});

// app.get("/",(req,res)=>{
//     res.json({
//         msg:"Hello World"
//     });
// });

// socket.emit() -> to single client
// socket.broadcast.emit() --> to all clients except the one that's connecting
// io.emit() --> to all clients

// function call(){
   
// }


io.on("connection",(socket)=>{
    console.log("Connection created");
    // while(true){
        // setTimeout((socket) => {
            console.log("inside call");
            socket.emit("price-value");
        // }, 5000);
    // }
});
    
    // while(true){
        // console.log("inside loop");
        // socket.on("message",(payload)=>{
        //     console.log("Payload",payload);
        //     // io.emit('new-message',payload);
        //     io.except(socket.id).emit('new-message',payload);
    
        // })


        // setTimeout(()=>{
        //     console.log("inside call")
        //     var val=Math.floor(Math.random()*500)+1;
        //     io.emit('price-value',val);
        // },5000);
    // }
   

    // socket.on("message",(payload)=>{
    //     console.log("Payload",payload);
    //     // io.emit('new-message',payload);
    //     io.except(socket.id).emit('new-message',payload);

    // })

const PORT= process.env.PORT || 5000;
server.listen(PORT, ()=>{
    console.log(`App started on port ${PORT}`)
});