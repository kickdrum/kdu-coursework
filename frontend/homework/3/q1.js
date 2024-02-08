// Question 1 a
const tipCalculator = (billAmounts) => {
  let tipAmounts = Array();
  let finalAmounts = Array();
  billAmounts.forEach((billAmount) => {
    if (billAmount < 50) {
      let tip = billAmount * 0.2;
      tipAmounts.push(tip);
      finalAmounts.push(billAmount + tip);
    } else if (billAmount < 200) {
      let tip = billAmount * 0.15;
      tipAmounts.push(tip);
      finalAmounts.push(tip + billAmount);
    } else {
      let tip = billAmount * 0.1;
      tipAmounts.push(tip);
      finalAmounts.push(tip + billAmount);
    }
  });
  let result = {
    tipAmounts: tipAmounts,
    finalAmounts: finalAmounts,
  };
  return result;
};

let billAmounts = [140, 45, 280];
let tipAmounts = tipCalculator(billAmounts);

console.log("Question 1 a : ");
console.log("bill amounts : ", billAmounts);
console.log("tip amounts : ", tipAmounts.tipAmounts);
console.log("final amounts : ", tipAmounts.finalAmounts);

// Question 1 b

let days = [
  "Sunday   ",
  "   Monday  ",
  "  Tuesday",
  "Wednesday  ",
  "  Thursday   ",
  "   Friday",

  "Saturday    ",
];

let modifiedDays = days.map((day) => {
  return day.trim().slice(0, 3).toUpperCase();
});
console.log("Question 1 b : ");
console.log('days before : ', days);
console.log('days after : ',modifiedDays);
