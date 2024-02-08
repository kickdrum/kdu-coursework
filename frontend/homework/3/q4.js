let jsonString =
  '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

// 1
let jsonObject = JSON.parse(jsonString, (key, value) => {
  if (key === "email") {
    return value;
  }
  if (typeof value === "string") {
    return value.toUpperCase();
  }
  return value;
});

console.log("Q4 A) Uppercase except email  : ", JSON.stringify(jsonObject));

//2
console.log(
  "Q4 B) converted to string with out email : ",
  JSON.stringify(jsonObject, (key, value) => {
    if (key !== "email") {
      return value;
    }
  },2)
);
