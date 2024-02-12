const path = require('path');

const extractFileInfo = (filePath) => {
    const parsedPath = path.parse(filePath);
    const extension = parsedPath.ext;
    const baseName = parsedPath.base;
    const directory = parsedPath.dir;

    return {extension,baseName,directory};
}

const processFilePaths = (filePaths) => {
    let results = [];
    filePaths.forEach(element => {
        const fileObj = extractFileInfo(element);
        results.push(fileObj);
    });
    return results;
}

const filePaths = [
    'q1.js',
    'q2.js',
    '../1/README.md',
    'system_info.json'
]

console.log(processFilePaths(filePaths));