function coded(text){
    text=text.replace(new RegExp("a","g"),"4");
    text=text.replace(new RegExp("e","g"),"3");
    text=text.replace(new RegExp("i","g"),"1");
    text=text.replace(new RegExp("o","g"),"0");
    text=text.replace(new RegExp("s","g"),"5");
    return text;
}

input="javascript is cool";
output=coded(input)
console.log(output);