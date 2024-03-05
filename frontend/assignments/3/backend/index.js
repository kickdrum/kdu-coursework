const express = require("express");
const cors = require("cors");
const socketIo = require("socket.io");

const app = express();
const server = http.createServer(app);
app.use(cors());
app.use(express.json());

const io = new socketIo.Server(server, {
  cors: {
    origin: "http://127.0.0.1:5714",
  },
});

io.on("connection", (socket) => {
  console.log(`connection established: ${socket.id}`);

  socket.on("join", (roomName) => {
    socket.join(roomName);
    console.log(`${socket.id} joined room: ${roomName}`);
  });

  socket.on("compelete", (message, roomName) => {
    message = "Akaash" + " " + message;
    console.log(message);
    io.to(roomName).except(socket.id).emit("send", message);
  });
});

server.listen(3000, () => {
  console.log(`Server is running on  http://localhost:3000`);
});
