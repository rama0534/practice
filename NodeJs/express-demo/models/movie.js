const func = require('joi/lib/types/func');
const Joi = require('joi');
Joi.objectId = require('joi-objectid')(Joi);
const mongoose = require('mongoose');
const { genreSchema } = require('./genres-mongo');
 
const   movieSchema = new mongoose.Schema({
    title:{
            type: String,
            required: true,
            minlength: 5,
            maxlength: 15
    },
    genre: {
        type: genreSchema
    },
    numberInstock: Number,
    dayRentalRate: Number
})

const Movie = mongoose.model('Movie', movieSchema);

function validateMovie(movie) {
    const schema = { 
        title: Joi.string().min(5).required(),
        genreId: Joi.objectId().required(),
        numberInstock: Joi.number().min(0).required(),
        dayRentalRate: Joi.number().min(0).required()
    }
     return Joi.validate(movie, schema);
}

exports.Movie = Movie;
exports.validateMovie = validateMovie;