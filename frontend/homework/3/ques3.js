const shoes = [
    { type: "sneakers", color: "black", size: 10, price: 50 },
    { type: "formals", color: "brown", size: 9, price: 60 }
];
  
const shirts = [
    { type: "t-shirt", color: "blue", size: "M", price: 20 },
    { type: "formal shirt", color: "white", size: "L", price: 30 },
    { type: "oversized shirt", color: "blue", size: "XL", price: 40 }
];

const warehouse=[];
function addToWarehouse(shoes,shirts){
    for(let i=0;i<shoes.length;i++){
        warehouse.push(shoes[i]);
    }
    for(let i=0;i<shirts.length;i++){
        warehouse.push(shirts[i]);
    }
}

function totalWorth(warehouse){
    var price=0;
    for(let i=0;i<warehouse.length;i++){
        price=price+warehouse[i].price;
    }
    return price;
}

function sortWarehouse(warehouse){
    warehouse.sort((a, b) => b.price - a.price);
}

function blueCloth(warehouse){
    const blueOutfit = warehouse.filter(product => product.color === "blue");
    return blueOutfit;
}


addToWarehouse(shoes,shirts);
console.log(warehouse);

total=totalWorth(warehouse);
console.log(total);

sortWarehouse(warehouse);
console.log(warehouse);

blueCloths=blueCloth(warehouse);
console.log(blueCloths);
