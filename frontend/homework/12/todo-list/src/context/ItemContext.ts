import { createContext } from "react";
import { ItemProps } from "../types/ItemProps";

export const ItemContext = createContext<{
  items: ItemProps[];
  setItems: (query: ItemProps[]) => void;
}>({
  items: [],
  setItems: () => {},
});
