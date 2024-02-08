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

let keys = [];
let values = [];
const getKeysAndValues = (obj) => {
  Object.entries(obj).forEach(([key, value]) => {
    if (typeof value === "object") {
      getKeysAndValues(value);
    } else {
      keys.push(key);
      values.push(value);
    }
  });
};
getKeysAndValues(player);
console.log("keys :", keys);
console.log("values :", values);
