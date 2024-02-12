const http = require('http');
const os = require('os');
const fs = require('fs');

function getSystemInfo() {
    return {
        HostName: os.hostname(),
        OperatingSystem: os.platform(),
        Architecture: os.arch(),
        OSRelease: os.release(),
        Uptime: os.uptime(),
        NumberOfCPUCores: os.cpus().length,
        TotalMemory: os.totalmem(),
        FreeMemory: os.freemem(),
        CurrentWorkingDirectory: process.cwd()
    };
}

function writeSystemInfoToFile() {
    const systemInfo = getSystemInfo();
    const jsonContent = JSON.stringify(systemInfo, null, 2);
    fs.writeFileSync('system_info.json', jsonContent);
}

writeSystemInfoToFile();

const server = http.createServer((req, res) => {
    fs.readFile('system_info.json', (err, data) => {
        if (err) {
            res.writeHead(500, { 'Content-Type': 'text/plain' });
            res.end('Internal Server Error');
        } else {
            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.end(data);
        }
    });
});

const PORT = 3000;
const HOST = 'localhost';

server.listen(PORT, HOST, () => {
    console.log(`Server running at http://${HOST}:${PORT}/`);
});

console.log(`Hello, my name is Prashant!`);
