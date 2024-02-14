import express from "express";
import cors from "cors";
import http from "http";
import { Server } from "socket.io";

const app = express();
app.use(express.static("public"));
app.use(express.json());

const server = http.createServer(app);
const io = new Server(server, {
    cors: {
        origin: "http://127.0.0.1:5501",
    },
});

app.use(cors());

io.on("connection", (socket) => {
    console.log("New connection");

    socket.on("message", (payload) => {
        console.log(`Message received on server: ${payload}`);
        io.except(socket.id).emit("new-message", payload);
    });
});

server.listen(5000, () => {
    console.log(`Server is running on port 5000`);
});
