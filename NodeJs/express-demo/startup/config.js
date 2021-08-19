const morgan = require('morgan');
const config = require('config');
const startupDebugger = require('debug')('app:startup');
const dbDebugger = require('debug')('app:db');
const { promise } = require('bcrypt/promises');

module.exports = function(app) {

    if(!config.get('jwtPrivateKey')){
        console.error("Fetal error");
        process.exit(1);
    };


    if(app.get('env') === 'development'){
        app.use(morgan('tiny'));
        startupDebugger("Morgan enabled.....");
    }

    console.log(`Application configure name ${config.get('name')}`);
    console.log(`Application configure name ${config.get('mail.host')}`);
    console.log(`Mail password ${config.get('mail.password')}`);
    console.log(`Private Key ${config.get('jwtPrivateKey')}`);


    

    // another Debugger db
    dbDebugger('Connected to database');

};