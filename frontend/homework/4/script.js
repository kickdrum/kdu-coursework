function createTodo() {

    let todoVal = document.getElementById("input-todo").value;
    console.log(todoVal);
    let ulEle = document.createElement("ul");
    let liEle = document.createElement("li");
 
    let textSpan = document.createElement("span");
    if(todoVal === "")
    {
        console.log("Empty input");
        return;
    }
    textSpan.innerText = todoVal;
    liEle.appendChild(textSpan);
 
 
    let deleteBtn = document.createElement("button");
    let deleteBtnText = document.createTextNode("Delete");
    deleteBtn.appendChild(deleteBtnText); 
    deleteBtn.addEventListener("click", (() => deleteTodo(ulEle, liEle)));
    liEle.appendChild(deleteBtn);

    let editBtn = document.createElement("button");
    let editBtnText = document.createTextNode("Edit");
    editBtn.appendChild(editBtnText); 
    editBtn.addEventListener("click", (() => editTodo(textSpan)));
    liEle.appendChild(editBtn);
 
    ulEle.appendChild(liEle);
    
    let todoBody = document.getElementById("todo");
    todoBody.appendChild(ulEle);
 }
 
 function deleteTodo(ulEle, liEle) {
     ulEle.removeChild(liEle);
 }

 function editTodo(textSpan) {
    let input = document.createElement("input");
    input.type = "text";
    input.value = textSpan.innerText;
 
    textSpan.replaceWith(input);
 
    input.focus();
 
    input.addEventListener("blur", function() {
        textSpan.innerText = input.value;
 
        input.replaceWith(textSpan);
    });
 }