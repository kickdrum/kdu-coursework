import { createContext } from "react";

export const TodoContext = createContext<ITodoContext>({
    theme: "light",
    toggleTheme: () => null,
});