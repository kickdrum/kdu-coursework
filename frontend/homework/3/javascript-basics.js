
// Question-1
function tipCalculator(bill){
    if(bill<50){
        return 0.20*bill;
    }
    else if(bill>=50 && bill<=200){
        return 0.15*bill;
    }
    else return 0.10*bill;
}


const BILLS=[140,45,280];
const TIPS=[];
const FINAL_AMOUNT=[];
for (let i = 0; i < BILLS.length; i++) {
    TIPS[i]=tipCalculator(BILLS[i]);
    FINAL_AMOUNT[i]=BILLS[i]+TIPS[i];
}

console.log(TIPS);
console.log(FINAL_AMOUNT);


// QUESTION-2
// 2 a

const DAYS=["Sunday   ","   Monday  ",

"  Tuesday","Wednesday  ","  Thursday   ","   Friday",

"Saturday    "]


for(let i=0;i<DAYS.length;i++){
    DAYS[i]=DAYS[i].trim().slice(0,3).toUpperCase();
    console.log(DAYS[i]);
}


// 2 b

function newString(oldString){
    let newstring=oldString.trim();

    newstring=newstring.replace(new RegExp("a",'g'),"4");
    newstring=newstring.replace(new RegExp("e",'g'),"3");
    newstring=newstring.replace(new RegExp("i",'g'),"1");
    newstring=newstring.replace(new RegExp("o",'g'),"0");
    newstring=newstring.replace(new RegExp("s",'g'),"5");
    return newstring;
}

console.log(newString("javascript is cool  "));
console.log(newString("programming is fun"));
console.log(newString("  become a coder"));


//  Question -3




let shoes = [
    { type: "formal-shoes", color: "black", size: 9, price: 50 },
    { type: "sneakers", color: "blue", size: 10, price: 30 }
];

let shirts = [
    { type: "t-shirt", color: "blue", size: "M", price: 20 },
    { type: "formal shirt", color: "white", size: "L", price: 25 },
    { type: "dress shirt", color: "blue", size: "S", price: 35 }
];


let warehouse = [];
// warehouse=warehouse.concat(shoes);
// warehouse=warehouse.concat(shirts);


shoes.forEach(shoe => {
    warehouse.push(shoe);
});

shirts.forEach(shirt => {
    warehouse.push(shirt);
});

let totalWorth = warehouse.reduce((total, product) => total + product.price, 0);


warehouse.sort((a, b) => b.price - a.price);

let blueProducts = warehouse.filter(product => product.color === "blue");

console.log("Total worth of products stored in the warehouse:", totalWorth);
console.log("Warehouse array sorted in descending order of prices:", warehouse);
console.log("Warehouse products which are blue in color:", blueProducts);


// Question - 4

// 4 a
let inputString ='{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';
let object = JSON.parse(inputString);

for(let key in object){
    if(key!="email"  && typeof object[key]==="string"){
        object[key]=object[key].toUpperCase();
    }
}

console.log(object);

// 4 b

delete object.email;
let outputString = JSON.stringify(object);
console.log(outputString);


// Question - 5 




function printKeys(obj) {
 
    for (let key in obj) {
        console.log(key);
        if (typeof obj[key] === 'object' && obj[key] !== null) {
            printKeys(obj[key]);
        }
    }

}



function printValues(obj) {
 
    for (let key in obj) {
        if (typeof obj[key] === 'object' && obj[key] !== null) {
            printValues(obj[key]);
        } else {
            console.log(obj[key]);
        }
    }

}


let player = {
    firstName: "Leo",
    lastName: "Messi",
    address: {
        country: "Spain",
        city: "Barcelona",
    },
    careerInfo: {
        fcBarcelona: {
            appearances: 780,
            goals: {
                premierLeagueGoals: 590,
                championsLeagueGoals: 50,
            },
        },
    },
};
console.log("All the keys :-");
printKeys(player);
console.log("\n");
console.log("All the values :-");
printValues(player);




