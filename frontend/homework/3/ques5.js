player = {
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

let keys = [];
let values = [];

function getAllKeysAndValues(obj) {
    function fun(obj) {
        for (let key in obj) {
            if (typeof obj[key] === 'object' && obj[key] !== null) {
                fun(obj[key]);
            } else {
                keys.push(key);
                values.push(obj[key]);
            }
        }
    }
    fun(obj);
}

getAllKeysAndValues(player);
console.log("All the keys:", keys);
console.log("All the values:", values);
