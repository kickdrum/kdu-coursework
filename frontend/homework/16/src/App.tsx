import { Header } from "./components/header/Header";
import { TodoContainer } from "./components/todoContiner/TodoContainer";

const styles = {
  app: {
    textalign: "center",
    fontFamily: "system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif",
  }
  
}

const App = () => {
  return (
    <div style={styles.app}>
      <Header />
      <TodoContainer />
    </div>
  );
};

export default App;
