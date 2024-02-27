import React from "react";
import { RootState } from "../../../state/store";
import { useDispatch, useSelector } from "react-redux";
import { setSearchItem } from "../../../state/Reducer/toDoListSlice";

const styles = {
  searchField: {
    height: "2.4rem",
    width: "30rem",
    fontSize: "1rem",
    outline: "none",
    paddingLeft: "1rem",
    borderRadius: "4px",
    marginRight: "2rem",
    border: "none",
  },
};

export const Searchfield = () => {
  const searchItem = useSelector(
    (state: RootState) => state.todoList.searchItem
  );
  const reduxDispatch = useDispatch();
  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    reduxDispatch(setSearchItem(e.target.value));
  };

  return (
    <div>
      <input
        type="text"
        style={styles.searchField}
        placeholder="Search Items.."
        value={searchItem}
        onChange={handleSearchChange}
        data-testid = "test-searchField"
      />
    </div>
  );
};
