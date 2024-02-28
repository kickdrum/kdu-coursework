import React from "react";
import "./App.scss";
import Header from "./components/Header/Header";
import AddItem from "./components/AddItem/AddItem";
import ItemContainer from "./components/ItemContainer/ItemContainer";
import { ItemProvider } from "./context/ItemContext";

const App:React.FC = () => {
    return (
        <ItemProvider>
            <div className="app-container">
                <Header />
                <div className="todo-container">
                    <AddItem />
                    <ItemContainer />
                </div>
            </div>
        </ItemProvider>
    );
};

export default App;
