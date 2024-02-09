const addItem = () => {
  const searchInput = document.querySelector(".todo-list__search");
  const searchText = searchInput.value.trim();

  if (searchText.length === 0) {
    alert("please add some content!");
    return;
  }
  if (searchText.length > 100) {
    alert("only 100 characters allowed!");
    return;
  }

  const listItem = document.createElement("li");
  listItem.textContent = searchText + " ";

  const deleteButton = document.createElement("button");
  deleteButton.textContent = "delete";
  const deleteClass = `delete-item`;
  deleteButton.classList.add("delete-item", deleteClass);
  listItem.appendChild(deleteButton);

  const editButton = document.createElement("button");
  editButton.innerText = "edit";
  editButton.id = "edit";
  listItem.append(editButton);

  const divItems = document.querySelector(".todo-list__list");
  divItems.appendChild(listItem);
  searchInput.value = "";

  deleteButton.addEventListener("click", (e) => {
    const deleteItem = e.target.parentElement;
    divItems.removeChild(deleteItem);
  });

  editButton.addEventListener("click", (e) => {
    const editItem = e.target.parentElement;
    const text = editItem.textContent;
    const newInput = document.createElement("input");
    newInput.value = text.slice(0, -10);
    newInput.id = "new-input";
    editItem.innerHTML = "";
    editItem.appendChild(newInput);

    const saveButton = document.createElement("button");
    saveButton.innerText = "save";
    saveButton.id = "save";
    editItem.appendChild(saveButton);

    saveButton.addEventListener("click", () => {
      const updatedItem = document.createElement("li");
      if (newInput.value === "") {
        alert("please add some content!");
        return;
      }
      if (newInput.length > 100) {
        alert("only 100 characters allowed!");
        return;
      }
      updatedItem.textContent = newInput.value.trim();
      newInput.style.width = "80vw";
      updatedItem.appendChild(deleteButton);
      updatedItem.appendChild(editButton);
      editItem.parentNode.replaceChild(updatedItem, editItem);
    });
  });
};

const addButton = document.getElementById("add");
addButton.addEventListener("click", addItem);
