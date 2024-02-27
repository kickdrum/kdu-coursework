import { Searchfield } from "./searchfield/Searchfield";
import { Headingtext } from "./Headingtext.tsx/Headingtext";

const styles = {
  headerContainer: {
    backgroundColor: "#28A745",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    padding: "1rem 21rem",
    height: "100px",
  },
};

export const Header = () => {
  return (
    <div style={styles.headerContainer}>
      <Headingtext />
      <Searchfield />
    </div>
  );
};
