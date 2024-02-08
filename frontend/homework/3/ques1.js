const bills=[140,45,280];
var tips=[];
var total=[];

function tipCalculator(arr){
    for(let i=0;i<arr.length;i++){
        if(arr[i]<=50){
            tips.push(0.20*arr[i]);
        }
        else if(arr[i]<=200){
            tips.push(0.15*arr[i]);
        }
        else{
            tips.push(0.10*arr[i]);
        }
        total.push(arr[i]+tips[i]);
    }
}

tipCalculator(bills);
console.log("The tips are as follows:"+ tips);
console.log("The total amounts to be paid are: "+ total);