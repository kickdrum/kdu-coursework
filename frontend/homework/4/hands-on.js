// get the add button
let addButton = document.getElementById("add-button");

// attaching a eventlistener
addButton.addEventListener("click", addTodo);

//Define Todo
function addTodo() {
	//get the input tag
	let inputTag = document.getElementById("todo-input");
	//get the input data
	const inputData = inputTag.value;
	if (inputData === "") {
		return;
	}
	//create a new list element
	const todoItem = document.createElement("li");
	//set the content to the data received from the input
	todoItem.textContent = inputData;
	//create button
	let deleteButton = document.createElement("button");
	deleteButton.textContent = "Delete";
	deleteButton.addEventListener("click", () => {
		todoList.removeChild(todoItem);
	});
	//get the list
	let todoList = document.getElementById("todo-list");
	todoItem.appendChild(deleteButton);
	//add the list
	todoList.appendChild(todoItem);
}
