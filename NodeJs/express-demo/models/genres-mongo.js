const Joi = require('joi');
const mongoose = require('mongoose');

const GenreSchema = new mongoose.Schema({
    genre:String
});

const Genre = mongoose.model('Genre', GenreSchema);

function validateGenre(genre) {
    const schema = {
        genre: Joi.string().min(3).required()
    }
     return Joi.validate(genre, schema);
}

exports.Genre = Genre;
exports.validateGenre = validateGenre;  
