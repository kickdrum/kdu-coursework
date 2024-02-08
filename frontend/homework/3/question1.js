bills = [140, 45, 280];
tips = [0, 0, 0];
paidAmount = bills;

function calculateAmount(bill, percentage) {
    return bill * percentage / 100;
}

function tipCalculator(bills) {
    for (var i = 0; i < bills.length; i++) {
        if(bills[i] < 50) {
            tips[i] = calculateAmount(bills[i], 20);
            paidAmount[i] = paidAmount[i] + tips[i];
        }
        else if(bills[i] < 201) {
            tips[i] = calculateAmount(bills[i], 15);
            paidAmount[i] = paidAmount[i] + tips[i];
        }
        else {
            tips[i] = calculateAmount(bills[i], 10);
            paidAmount[i] = paidAmount[i] + tips[i];
        }
    }
}

tipCalculator(bills);

console.log(tips);
console.log(paidAmount);