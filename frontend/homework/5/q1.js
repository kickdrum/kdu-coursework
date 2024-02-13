const os = require('os')
const path = require('path')

function getSystemInfo(){
    const systemInfo = {
        HostName : os.hostname(),
        OperatingSystem : os.platform(),
        Architecture: os.arch(),
        OSRelease: os.release(),
        Uptime: os.uptime(),
        NumberofCPUCores: os.cpus().length,
        TotalMemory: os.totalmem(),
        FreeMemory: os.freemem(),
        CurrentWorkingDirectory: path.resolve('./')
    };

    const uptime = systemInfo.Uptime;
    const hours = Math.floor(uptime / 3600);
    const minutes = Math.floor((uptime % 3600) / 60);
    const seconds = Math.floor(uptime % 60);
    systemInfo.Uptime = `${hours} hours, ${minutes} minutes, ${seconds} seconds`;

    systemInfo.TotalMemory = `${(systemInfo.TotalMemory / (1024 * 1024)).toFixed(2)} MB`;
    systemInfo.FreeMemory = `${(systemInfo.FreeMemory / (1024 * 1024)).toFixed(2)} MB`;

    return systemInfo;
}

const fs = require('fs')

function writeToFile(data) {
    const jsonData = JSON.stringify(data, null, 2); 
    fs.writeFile('system_info.json', jsonData, (err) => {
        if (err) {
            console.error('Error writing to file:', err);
        } else {
            console.log('System information written to system_info.json');
        }
    });
}

const info = getSystemInfo();
writeToFile(info);

const readJsonFile = () => {
    const filePath = path.join(__dirname, 'system_info.json');
    try {
        const data = fs.readFileSync(filePath, 'utf8');
        return JSON.parse(data);
    } catch (error) {
        console.error('Error reading JSON file:', error);
        return null;
    }
};

const http = require('http')

const server = http.createServer((req, res) => {
    if (req.method === 'GET' && req.url === '/') {
        const systemInfo = readJsonFile();

        let responseData = 'Hello, my name is Kunal!\n';
        responseData += 'Here is my system information:\n';
        responseData += JSON.stringify(systemInfo, null, 2);

        res.writeHead(200, { 'Content-Type': 'text/plain' });
        res.end(responseData);
    } else {
        res.writeHead(404, { 'Content-Type': 'text/plain' });
        res.end('404 Not Found');
    }
});

const PORT = process.env.PORT || 4000;
server.listen(PORT, () => {
    console.log(`Server is running at http://localhost:${PORT}/`);
});