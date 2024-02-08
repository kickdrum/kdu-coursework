function codeString(inputString) {
    inputString = inputString.trim(); // Remove leading and trailing whitespaces
    inputString = inputString.replace(new RegExp("a","g"), '4'); 
    inputString = inputString.replace(new RegExp("e","g"), '3');
    inputString = inputString.replace(new RegExp("i","g"), '1');
    inputString = inputString.replace(new RegExp("o","g"), '0');
    inputString = inputString.replace(new RegExp("s","g"), '5');

    return inputString; 
}

console.log(codeString("    javascript is cool"));
console.log(codeString("    programming is fun"));
console.log(codeString("    become a coder"));