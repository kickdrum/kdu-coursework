const text='{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';

function toJson(text){
    var ans= JSON.parse(text);
    return ans;
}

function upperCase(jsonObj){
    for(let key in jsonObj){
        if (key!=='email' && typeof jsonObj[key] === 'string'){
            jsonObj[key]=jsonObj[key].toUpperCase();
        }
    }
    return jsonObj;
}

function StringWithoutEmail(jsonObj){
    delete jsonObj.email;
    const ans=JSON.stringify(jsonObj);
    return ans;
}
const jsonObj= toJson(text);
console.log(jsonObj);

jsonObj2=upperCase(jsonObj);
console.log(jsonObj2);

const ansText=StringWithoutEmail(jsonObj2);
console.log(ansText);



