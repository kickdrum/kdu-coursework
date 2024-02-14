const socket = io("http://localhost:5000");
const messageInput = document.getElementById("messageInput");
const sendBtn = document.getElementById("sendBtn");
const messages = document.getElementById("messages");

messageInput.addEventListener("keyup", function (event) {
    if (event.key === "Enter") {
        sendBtn.click();
    }
});

function addMessage(from, message) {
    const messageUser = document.createElement("div");
    from === "You"
        ? messageUser.classList.add("message-you")
        : messageUser.classList.add("message-user");

    const messageHeader = document.createElement("div");
    messageHeader.classList.add("message-header");

    const username = document.createElement("span");
    username.classList.add("username");
    username.innerText = from === "You" ? "Y" : "U";

    messageHeader.appendChild(username);

    messageUser.appendChild(messageHeader);

    const messageBody = document.createElement("div");
    messageBody.classList.add("message-body");
    const messageText = document.createElement("p");
    messageText.innerText = message;

    messageBody.appendChild(messageText);
    messageUser.appendChild(messageBody);

    messages.appendChild(messageUser);
    messages.scrollTop = messages.scrollHeight;
}

sendBtn.addEventListener("click", function () {
    if (messageInput.value.trim() === "") {
        messageInput.value = "";
        return;
    }

    const message = messageInput.value;
    addMessage("You", message);
    messageInput.value = "";
    socket.emit("message", message);
});

socket.on("new-message", function (message) {
    addMessage("User", message);
});
