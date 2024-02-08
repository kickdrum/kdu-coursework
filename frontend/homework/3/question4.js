// part a
const inputString = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24,"city":"london","country":"england"}';

let jsonObject = JSON.parse(inputString);
for (let key in jsonObject) {
    if (typeof jsonObject[key] === 'string' && key !== 'email') {
        jsonObject[key] = jsonObject[key].toUpperCase();
    }
}

console.log(jsonObject);

// part b
delete jsonObject.email; 
let modifiedString = JSON.stringify(jsonObject);

console.log(modifiedString);

