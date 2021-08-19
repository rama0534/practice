const express = require('express');
const { json } = require('express');
const courses = require('../routers/courses');
const genres = require('../routers/exercise');
const genresmongo = require('../routers/genres-mongo');
const customers = require('../routers/customers');
const movies = require('../routers/movies')
const rental = require('../routers/rentals');
const user = require('../routers/users');
const auth = require('../routers/auth');
const err = require('../middleware/error')
const logger = require('../middleware/logger')

module.exports = function(app){
    app.use(express.json());
    app.use(logger);
    app.use('/api/courses', courses);
    app.use('/api/genres', genres);
    app.use('/api/genres-mongodb', genresmongo);
    app.use('/api/customer', customers);
    app.use('/api/movies', movies);
    app.use('/api/rentals', rental);
    app.use('/api/users', user);
    app.use('/api/auth', auth);
    app.use(err);
}