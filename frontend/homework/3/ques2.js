const weekdays=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
function shorten(weekdays){
    for(let i=0;i<weekdays.length;i++){
        var day=weekdays[i];
        day=day.substring(0,3);
        day=day.toUpperCase();
        weekdays[i]=day;
    }
}

shorten(weekdays);
console.log(weekdays);

