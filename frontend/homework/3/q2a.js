function convertToAbbreviatedUpperCase(arr) {
  const abbreviatedDays = []; 
  // Loop through each day in the input array
  for (let i = 0; i < arr.length; i++) {
    const day = arr[i].trim(); // Remove leading and trailing whitespaces
    const abbreviatedDay = day.substring(0, 3).toUpperCase(); // Extract first three characters and convert to uppercase
    abbreviatedDays.push(abbreviatedDay);
  }
  return abbreviatedDays; 
}

const days = ["Sunday "," Monday ", " Tuesday","Wednesday "," Thursday "," Friday", "Saturday "]; 
const abbreviatedDays = convertToAbbreviatedUpperCase(days);
console.log(abbreviatedDays); 