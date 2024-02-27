import React, { useState } from "react";
import { RootState } from "../../../state/store";
import { useDispatch, useSelector } from "react-redux";
import { setTodoList } from "../../../state/Reducer/toDoListSlice";

const styles = {
  inputArea: {
    marginLeft: "10px",
  },
  addItem: {
    marginTop: "1rem",
    marginBottom: "4px",

    fontSize: "40px",
  },

  input: {
    padding: "10px",
    fontSize: "17px",
  },

  button: {
    backgroundColor: "rgb(52,58,64)",
    color: "white",
    borderRadius: "4px",
    border: "none",
    fontSize: "20px",
    padding: "0.6rem 0.7rem 0.7rem 0.7rem",
    marginLeft: "10px",
    marginTop: "2px",
  },
};

export const InputField = () => {
  const [task, setTask] = useState<string>("");
  const todoList = useSelector((state: RootState) => state.todoList.todoList);
  const reduxDispatch = useDispatch();

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setTask(event.target.value);
  };

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    if (task.trim() !== "") {
      const updatedList = [...todoList, task];
      reduxDispatch(setTodoList(updatedList));
      setTask("");
    }
  };

  return (
    <div style={styles.inputArea}>
      <p style={styles.addItem}>Add Items</p>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          style={styles.input}
          value={task}
          onChange={handleInputChange}
          data-testid = "test-inputField"
        />
        <button type="submit" style={styles.button} data-testid = "test-submitBtn">
          Submit
        </button>
      </form>
    </div>
  );
};
