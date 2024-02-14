const chatsDiv = document.getElementById("chatsDiv");
const inputField = document.getElementById("inputField");
const roomSelect = document.getElementById("room");


// creating socket to listen server
const socket = io("http://localhost:5000");


// listening broadcasted message from server
socket.on("chatMessage", (msgObject) => {
    console.log(`Message received from ${msgObject.username} in ${msgObject.roomName} (${msgObject.time}): ${msgObject.message}`);
    addNewMessage(msgObject);
});



// functions
const sendMessage = () => {

    const message = inputField.value;
    const roomName = roomSelect.value;

    console.log("client: " + message + " " + roomName);

    socket.emit('joinRoom', roomName);
    socket.emit("chatMessage", message, roomName);
    inputField.value = "";
}


const addNewMessage = (msgObject)=>{

    let {id, message} = msgObject;

    let postDiv = document.createElement("div");
    let usernameSpan = document.createElement("span");
    usernameSpan.innerText = "U";

    if(socket.id === id){
        usernameSpan.innerText = "Y";
    }

    let para = document.createElement("p");
    para.textContent = message;

    postDiv.classList.add("chat");
    usernameSpan.classList.add("class");

    postDiv.appendChild(usernameSpan);
    postDiv.appendChild(para);
    chatsDiv.appendChild(postDiv);
}