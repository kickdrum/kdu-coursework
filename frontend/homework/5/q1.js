const os = require('os');
const fs = require('fs');
const http = require('http');

const server = http.createServer((req,res) => {
    if(req.url === '/get'){
        getDetails(res);
    }
});

const getSystemInfo = () => {
    const hostname = os.hostname();
    const osName = os.platform();
    const architecture = os.arch();
    const osRelease = os.release();
    const uptime = os.uptime();
    const cpuCores = os.cpus().length;
    const totalMemory = os.totalmem();
    const freeMemory = os.freemem();
    const cwd = process.cwd();

    const systemInfo = {
        HostName: hostname,
        OperatingSystem: osName,
        Architecture: architecture,
        OSRelease: osRelease,
        Uptime: uptime,
        NumberOfCPUCores: cpuCores,
        TotalMemory: totalMemory,
        FreeMemory: freeMemory,
        CurrentWorkingDirectory: cwd
    };

    return systemInfo;
}

function createJsonFile(filename) {
    const systemInfo = getSystemInfo();
    fs.writeFileSync(filename, JSON.stringify(systemInfo,null,2));
}

function getDetails(res){
    const yourName = "Kartik";``
    const filename = 'system_info.json';
    createJsonFile(filename);

    console.log(`Hello, my name is ${yourName}!\n`);
    console.log('Here is my system information:\n');
    const systemInfo = fs.readFileSync(filename);
    console.log(systemInfo.toString());
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end(systemInfo.toString());

}

server.listen(3001);
