import React from "react";
import "./App.scss";
import Header from "./components/Header/Header";
import AddItem from "./components/ItemOperation/ItemOperation";
import ItemContainer from "./components/ItemContainer/ItemContainer";
import { Provider } from "react-redux";
import { store } from "./redux/store";

const App:React.FC = () => {
    return (
        <Provider store={store}>

            <div className="app-container">
                <Header />
                <div className="todo-container">
                    <AddItem />
                    <ItemContainer />
                </div>
            </div>

        </Provider>
    );
};

export default App;
