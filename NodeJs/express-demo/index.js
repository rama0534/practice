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
const genresmongo = require('./routers/genres-mongo')
const customer = require('./routers/customer')
const mongoose = require('mongoose');
app.use(express.json());

// app.use(express.urlencoded({extened: true}));
app.use(express.static('public'));
mongoose.connect('mongodb://localhost/genres', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log("Connected to Genres Database"))
    .catch(err => console.log("Could not connect to the Genres Database",err));
//Middleware 
app.use(logger);
app.use('/api/courses', courses);
app.use('/api/genres', genres);
app.use('/api/genres-mongodb', genresmongo);
app.use('/api/customer', customer);


console.log(`Application configure name ${config.get('name')}`);
console.log(`Application configure name ${config.get('mail.host')}`);
// console.log(`Mail password ${config.get('mail.password')}`);

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
