
const os = require('os');
const fs = require('fs');
const EventEmitter = require('events');
const emitter = new EventEmitter();
const Logger = require('./logger');

// console.log(logger);
console.log(os.type());

//synchronous
const files = fs.readdirSync('./')
console.log(files);


//asynchronous
fs.readdir('./', function(err, files) {
    if(err) console.log('error');
    else console.log('Result', files);
});

//Listner 
emitter.on('messageLogged', (args) => {
    console.log('Listerner called', args);
})




