const path = require('path');

function extractFileInfo(filePath) {
    const extension = path.extname(filePath);
    const baseName = path.basename(filePath);
    const directory = path.dirname(filePath);

    return {
        extension,
        baseName,
        directory
    };
}

function processFilePaths(filePaths) {
    const fileInfoArray = filePaths.map(filePath => extractFileInfo(filePath));
    return fileInfoArray;
}

const filePaths = [
    'dir1/dir2/file1.txt',
    'dir1/dir3/file2.txt',
    'dir1/dir3/file3.md',
    'dir4/file4.jpg',
    'dir4/file5.pdf',
];

const filesInfo = processFilePaths(filePaths);
console.log(filesInfo);