const http = require('http');
const server = http.createServer((req, res) => {
    if(req.url === '/') {
        res.write('Hello World!');
        res.end();
    }

    if(req.url === '/login') {
        res.write(JSON.stringify([1, 2, 3]));
        res.end();
    }
});

server.listen(3000);
console.log('Listending on port number 3000');

