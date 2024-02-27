const styles = {
  heading: {
    fontSize: "40px",
    color: "white",
    fontWeight: "400",
    paddingLeft: "2rem",
  },
};

export const Headingtext = () => {
  return <h1 style={styles.heading} data-testid = "test-headingText">Item Lister</h1>;
};
