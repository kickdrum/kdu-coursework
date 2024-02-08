let sneaker = {
  type: "nike",
  color: "blue",
  size: "UK 8",
  price: 20000,
};

let formal = {
  type: "addidas",
  color: "black",
  size: "UK 8",
  price: 15000,
};

let shoes = [sneaker, formal];
let shirt1 = {
  type: "raymond",
  color: "blue",
  size: "25",
  price: 5000,
};
let shirt2 = {
  type: "armani",
  color: "black",
  size: "25",
  price: 3000,
};
let shirt3 = {
  type: "essentials",
  color: "black",
  size: "25",
  price: 8000,
};
let shirts = [shirt1, shirt2, shirt3];
// 1
let warehouse = [...shirts, ...shoes];
console.log("Q3 A  : all items", warehouse);
//2
let total = 0;
warehouse.forEach((item) => (total = total + item.price));
console.log("Q3 B : total price", total);
//3
console.log(
  "Q3 C : sorted warehouse",
  warehouse.sort((item1, item2) => item1.price - item2.price)
);
//4
console.log(
  "Q3 D : blue items",
  warehouse.filter((item) => item.color === "blue")
);
