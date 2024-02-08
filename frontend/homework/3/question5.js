const player = {
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

keys = [];
values = [];

function outputObjectKeysAndValues(obj) {
    for (let key in obj) {
        keys.push(key);
        if (typeof obj[key] === 'object') {
            outputObjectKeysAndValues(obj[key]);
        }
        else {
            values.push(obj[key]);
        }
    }
}

outputObjectKeysAndValues(player);

console.log(keys);
console.log(values);
