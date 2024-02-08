// part a
weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

const abbreviatedWeekdays = weekdays.map((day) => {
    return day.slice(0, 3).toUpperCase();
})

console.log(abbreviatedWeekdays);

// part b

const mappings = {
    'a': '4',
    'e': '3',
    'i': '1',
    'o': '0',
    's': '5'
};

function codeString(input){
    input = input.trim();
    for (let i = 0; i < input.length; i++) {
        if(mappings[input.charAt(i)]){
            input = input.replace(input.charAt(i), mappings[input.charAt(i)]);
        }
    }
    console.log(input);
}

codeString('javascript is cool');
codeString('programming is fun');
codeString('  become a coder');
