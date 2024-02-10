let addbutton = document.getElementById("add-button");
let todoList = document.getElementById("todo-list"); 

addbutton.addEventListener("click", addTodo);

function addTodo(){
    let inputTag = document.getElementById("todoText");
    const data = inputTag.value;
    if (data === "") return;
    let checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.id = "check";
    let deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", () => {
        let todoItem = deleteButton.parentElement;
        todoList.removeChild(todoItem);
    });
    let label = document.createElement("label");
    label.htmlFor = "check";
    label.appendChild(checkbox);
    label.appendChild(document.createTextNode(data));
    const item = document.createElement("li");
    item.appendChild(label);
    item.appendChild(deleteButton);
    let list = document.getElementById("todo-list");
    list.append(item);
}
