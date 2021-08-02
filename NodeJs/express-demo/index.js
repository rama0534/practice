const { json } = require('express');
const express =  require('express');
const logger = require('./Middleware/logger')
const Joi = require('joi');
const func = require('joi/lib/types/func');
const app = express();
const morgan = require('morgan');
const config = require('config');
const startupDebugger = require('debug')('app:startup');
const dbDebugger = require('debug')('app:db');
const courses = require('./routers/courses');
const genres = require('./routers/exercise');
app.use(express.json());
// app.use(express.urlencoded({extened: true}));
app.use(express.static('public'));
//Middleware 
app.use(logger);
app.use('/api/courses', courses);
app.use('/api/genres', genres);

console.log(`Application configure name ${config.get('name')}`);
console.log(`Application configure name ${config.get('mail.host')}`);
console.log(`Mail password ${config.get('mail.password')}`);

if(app.get('env') === 'development'){
    app.use(morgan('tiny'));
    startupDebugger("Morgan enabled.....");
}

// another Debugger db
dbDebugger('Connected to database');

app.get('/', (req, res) => {
    res.send('Hello world!');
});

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));
