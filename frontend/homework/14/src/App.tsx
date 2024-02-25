import "./App.css";
import MyComponent from "./component_files/MyComponent";
import MyForm from "./component_files/MyForm";
import ScrollToTop from "./component_files/ScrollToTop";
import Timer from "./component_files/Timer";

export function App() {
  return (
    <>
      <Timer />
      <ScrollToTop />
      <MyForm />
      <MyComponent />
    </>
  );
}
