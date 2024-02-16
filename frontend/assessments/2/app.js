const express= require("express");
const http=require("http");
const cors=require("cors");
const socketIo=require("socket.io");

const app=express();
const server=http.createServer(app);
const io=new socketIo.Server(server, {
    cors:{
        origin: "http://127.0.0.1:5500"
    }
});
app.use(cors())

app.use(express.json())

app.get("/", (req,res)=>{
    res.json({
        "msg":"Hello world!"
    })
});

io.on("connection", (socket) =>{
    console.log("Connection created");

    const text="Zomato";
    console.log("test going")
    socket.emit("receive-zomato-text",text);

    const price=Math.floor(Math.random() * 501);
    socket.emit("receieve-prices", price);
    
    socket.on("message",(payload)=>{
        io.to(payload.room).except(socket.id).emit("new-message",payload.message)
    })

    socket.on("roomNo",(payload)=>{
        console.log("Payload",payload);
        socket.join(payload);  
    })
})  

server.listen(5000, ()=>{
    console.log("working")
})
