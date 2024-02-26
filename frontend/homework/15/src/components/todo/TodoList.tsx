import { Header } from "./header/Header";
import { TodoSection } from "./todo-section/TodoSection";

export function Todo() {
    return (
        <div className="todo-list">
            <Header />
            <TodoSection />
        </div>
    );
}
