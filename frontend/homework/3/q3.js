function calculateTotalPrice(products) {
    // Use reduce to sum up the prices of all products
    return products.reduce((total, product) => total + parseInt(product.price), 0);
}

function sortWarehouseByPrice(warehouse) {
    // Use slice to create a shallow copy of the warehouse array, then sort it based on product price
    return warehouse.slice().sort((a, b) => parseInt(a.price) - parseInt(b.price));
}

function filterProductsByColor(warehouse, color) {
    // Use filter to select products with the specified color
    return warehouse.filter(product => product.colour === color);
}

let shoes = [
    {
        type: "sneakers",
        colour: "white",
        size: "5",
        price: "5500"
    },
    {
        type: "sports shoes",
        colour: "black",
        size: "5",
        price: "2500"
    }
];

let shirts = [
    {
        type: "T shirt",
        colour: "red",
        size: "M",
        price: "700"
    },
    {
        type: "T shirt",
        colour: "blue",
        size: "M",
        price: "800"
    },
    {
        type: "T shirt",
        colour: "black",
        size: "M",
        price: "600"
    }
];

// Combine shoe and shirt products into a single warehouse
let warehouse = [...shoes, ...shirts];

// Calculate the total price of all products in the warehouse
let sum = calculateTotalPrice(warehouse);

// Sort the warehouse products by price
let sortedWarehouse = sortWarehouseByPrice(warehouse);

// Filter products in the warehouse by color (e.g., blue)
let blueProducts = filterProductsByColor(warehouse, "blue");

console.log("Total price of all products:", sum);
console.log("Warehouse products sorted by price:", sortedWarehouse);
console.log("Blue products in the warehouse:", blueProducts);
