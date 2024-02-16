const socket=io("http://localhost:5000");
// const messageInput=document.getElementById("msgInput");
// const sendButton=document.getElementById("sendMessage");
// const messageOutput=document.getElementById("messages");

const priceNumber=document.querySelector('.price-number');
const quantity=document.querySelector('.quantity input');
const buybutton =document.querySelector('.buy button');
const sellbutton=document.querySelector('.sell button');
const stockscontent =document.querySelector('.right-content');

function addMessage(from, message) {
    // Create message container div
    var val=parseInt(message);
    const messageContainer = document.createElement('div');
    messageContainer.classList.add('message-container');
    if(from=="buy") messageContainer.innerText=` Buy ${val} stocks `;
    else messageContainer.innerText=` Sell ${val} stocks `;
    stockscontent.appendChild(messageContainer);
    // // Create icon (assuming it's an image)
    // const icon = document.createElement('img');
    // if(from==="User") icon.src = 'man.png'; // Path to your icon image
    // else icon.src='girl.png';
    // messageContainer.appendChild(icon);

    // Create message paragraph
    // const messagePara = document.createElement('p');
    // messagePara.classList.add('message-text');
    // messagePara.innerText = `${from}: ${message}`;
    // messageContainer.appendChild(messagePara);

    // Append message container to the messages div
  
    
}


buybutton.addEventListener("click",()=>{
    const message = quantity.value;
    if(message===""){
        window.alert("please enter some number");
        return;
    }
    addMessage("buy",message);
// send to particular message over websockets
    // socket.emit("message",message);
    quantity.value='';
    
});

sellbutton.addEventListener("click",()=>{
    const message = quantity.value;
    if(message===""){
        window.alert("please enter some number");
        return;
    }
    addMessage("sell",message);
// send to particular message over websockets
    // socket.emit("message",message);
    quantity.value='';
    
});

// socket.on("new-message",(message)=>{
//     addMessage("User",message)
// })

var prev;
function changePrice(newval){
    // console.log(priceNumber);
    var oldval=parseInt(priceNumber.textContent);
    if(newval>oldval) priceNumber.style.color='green';
    else priceNumber.style.color='red';
    priceNumber.textContent=`${newval} $`;
    

}
socket.on("price-value",()=>{
    start(); 
}
)


function start() {

    setTimeout(function() {
        // setTimeout(() => {
            var newval=Math.floor(Math.random()*500)+1;
            changePrice(newval);
            
        // }, 5000);

      start();

    }, 5000);
}


