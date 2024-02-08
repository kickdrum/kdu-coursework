function tipCalculator(bills, tips, totalAmounts) {
    // Loop through each bill
    for (let i = 0; i < bills.length; i++) {
        let tip; 
        let totalAmount;
        
        // Calculate tip based on bill amount
        if (bills[i] < 50) { 
            tip = bills[i] * 0.20; 
        } else if (bills[i] >= 50 && bills[i] <= 200) {
            tip = bills[i] * 0.15; 
        } else {
            tip = bills[i] * 0.10; 
        }

        // Calculate total amount paid
        totalAmount = bills[i] + tip;
        
        // Push tip and total amount to their respective arrays
        tips.push(tip);
        totalAmounts.push(totalAmount);
    }
}

const bills = [140, 45, 280];
let tips = [];
let totalAmounts = []; 
tipCalculator(bills, tips, totalAmounts); // Calculate tips and total amounts

console.log("Tips:", tips); 
console.log("Total Amounts Paid:", totalAmounts); 