const shoes = [
    { type: 'sneakers', color: 'black', size: 9, price: 50 },
    { type: 'loafers', color: 'brown', size: 10, price: 80 }
];

const shirts = [
    { type: 'polo', color: 'blue', size: 'M', price: 30 },
    { type: 't-shirt', color: 'white', size: 'L', price: 20 },
    { type: 'button-down', color: 'blue', size: 'XL', price: 40 }
];

const warehouse = [...shoes, ...shirts];

totalWorth = 0;
for (var i = 0; i < warehouse.length; i++) {
    totalWorth = totalWorth + warehouse[i].price;
}

console.log("TotalWorth:", totalWorth);

warehouse.sort((a, b) => b.price - a.price);

console.log("Warehouse sorted on the price:", warehouse);

const blueProducts = warehouse.filter(item => item.color === 'blue');
console.log("Warehouse products which are blue in color:", blueProducts);
