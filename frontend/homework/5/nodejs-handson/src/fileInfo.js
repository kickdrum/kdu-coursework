// importing module
const path = require("path");

// Function to extract information from a single file path
function extractFileInfo(filePath) {
  return {
    extension: path.extname(filePath),
    baseName: path.basename(filePath),
    directory: path.dirname(filePath),
  };
}

// Function to process an array of file paths
function processFilePaths(filePaths) {
  return filePaths.map((filePath) => extractFileInfo(filePath));
}

// Sample file paths to process
const filePaths = [
  "dir1/dir2/file1.txt",
  "dir1/dir3/file2.txt",
  "dir1/dir3/file3.md",
  "dir4/file4.jpg",
  "dir4/file5.pdf",
];

// Processing the sample file paths and logging the result
const processedPaths = processFilePaths(filePaths);
console.log(processedPaths);
