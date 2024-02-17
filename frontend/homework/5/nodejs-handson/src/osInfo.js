// Importing modules
const os = require("os");
const fs = require("fs");
const path = require("path");

// Function to gather system information
function getSystemInfo() {
  return {
    HostName: os.hostname(),
    OperatingSystem: os.type(),
    Architecture: os.arch(),
    OSRelease: os.release(),
    Uptime: os.uptime(),
    NumberOfCPUCores: os.cpus().length,
    TotalMemory: os.totalmem(),
    FreeMemory: os.freemem(),
    CurrentWorkingDirectory: process.cwd(),
  };
}

// Function to write system information to a JSON file
function writeSystemInfoToFile() {
  const info = getSystemInfo();
  // Defining the output path for the JSON file
  const outputPath = path.join(__dirname, "systemInfo.json");
  // Writing the information to the file in a pretty-printed format
  fs.writeFileSync(outputPath, JSON.stringify(info, null, 2), "utf8");
  console.log("System information written to systemInfo.json");
}

// Call the function to write the system info
writeSystemInfoToFile();

console.log("TEST");