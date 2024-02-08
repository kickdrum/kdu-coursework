function outputKeysAndValues(obj) {
    // Output all keys
    console.log("All the keys:");
    for (let key in obj) {
        console.log(key);
        if (typeof obj[key] === 'object') {
            // If the value is an object, recursively call the function
            outputKeysAndValues(obj[key]);
        }
    }

    // Output all values
    console.log("\nAll the values:");
    for (let key in obj) {
        if (typeof obj[key] !== 'object') {
            console.log(obj[key]);
        } else {
            // If the value is an object, recursively call the function
            outputKeysAndValues(obj[key]);
        }
    }
}

// Example usage:
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

outputKeysAndValues(player);
