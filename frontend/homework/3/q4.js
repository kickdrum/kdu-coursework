// Input string
const inputString = '{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

// Convert input string to JSON object
const jsonObject = JSON.parse(inputString);

// Convert values to uppercase except for email
for (let key in jsonObject) {
    if (key !== 'email' && typeof jsonObject[key] === 'string') { 
        jsonObject[key] = jsonObject[key].toUpperCase();
    }
}

// Convert JSON object back to string without the email key-value pair
delete jsonObject.email; 
const outputString = JSON.stringify(jsonObject);

console.log(jsonObject);
console.log(outputString);
