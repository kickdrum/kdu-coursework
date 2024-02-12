const os = require('os');
const http = require('http');
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

const systemInfo = getSystemInfo();
console.log(systemInfo);

function writeSystemInfoToFile(filename) {
    const json = JSON.stringify(systemInfo, null, 2);
    fs.writeFileSync(filename, json);
}

writeSystemInfoToFile('systemInfo.json');

const server = http.createServer((req, res) => {
    if (req.url === '/') {
        fs.readFile('systemInfo.json', (err, data) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('Internal Server Error');
                return;
            }

            res.writeHead(200, { 'Content-Type': 'application/json' });
            res.end(data);
        });
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('Not Found');
    }
});

const PORT = process.env.PORT || 3000;

// Start the server
server.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
