import { InputField } from "./InputItems/InputField";
import { TodoList } from "./main/TodoList";

const styles = {
  mainContainer: {
    border: "2px solid #eeeeee",
    margin: "1rem 20%",
    paddingLeft: "1rem",
    borderRadius: "4px",
  },
};

export const TodoContainer = () => {
  return (
    <div style={styles.mainContainer}>
      <InputField />
      <TodoList />
    </div>
  );
};
