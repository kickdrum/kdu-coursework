//get the add button
const button=document.getElementById("add-button")

//attach a clickListerner
button.addEventListener("click",todo)

//Define addTodo
function todo(){

    //get the input tag
    let inputTag=document.getElementById("todo-input");

    // get the data from input tag
    const data=inputTag.value;
    if(data===""){
        return;
    }
    console.log("data: ",data);

    // create new list element
    const todoItem=document.createElement("li");
    const dlt=document.createElement("button");

    
    // set the content to data received from input
    todoItem.textContent=data;

    // get the ul object reference
    let todoList=document.getElementById("todo-list");
    dlt.textContent="delete";

    // append the li item to ul
    todoList.appendChild(todoItem);
    todoList.appendChild(dlt);
    
    dlt.addEventListener("click",deleteThis);
    function deleteThis(){
        todoList.removeChild(todoItem);
        todoList.removeChild(dlt);
    }
}

