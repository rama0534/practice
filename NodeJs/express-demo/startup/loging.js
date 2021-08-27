const winston = require('winston');
require('express-async-errors');
// require('winston-mongodb');

module.exports = function(){

    process.on('uncaughtException', (ex) => {
    console.log("we got an uncaught exception.", ex);
    winston.error(ex.message, ex);
        process.exit(1);
    });

    process.on('unhandledRejection', (ex) => {
        console.log("WE GOT AN UNHANDLEDREJCTION");
        winston.error(ex.message, ex);
        process.exit(1); 
    });

    // winston.add(winston.transports.File, { filename: 'logfile.log'});
    winston.add(new winston.transports.File({ filename: 'logfile.log'}));
    // winston.add(new winston.transports.MongoDB({db: 'mongodb://localhost/playground'} ));
    // winston.ExceptionHandler(new winston.transports.File({filename: 'uncaughtException.log'}));
    /* Example of uncaught exception */
    // throw new Error('Something failed during the startup.');

    /* Example of unhandleRejection exception */
    // const p = Promise.reject(new Error('Something find miserbly'));
    // p.then(() => console.log('Done'));
};