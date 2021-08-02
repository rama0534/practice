const express = require('express');
const router = express.Router();
const Joi = require('joi');

const genres = [
    {id:1, genre:"Romance"},
    {id:2, genre:"Action"},
    {id:3, genre:"Drama"},
    {id:4, genre:"Horror"},
]

router.get('/', (req, res) => {
    res.send(genres);
});

router.get('/:id', (req, res) => {
    const genre = genres.find(g => g.id === parseInt(req.params.id));
    if(!genre) return res.status(400).send(`The requested genre with given   ${req.params.id} was not found.`);
    res.send(genre);
});

router.post('/', (req, res) => {
    const result = validateGenre(req.body);
    if(result.error) return res.status(400).send(result.error.details[0].message);
    const genre = {
        id: genres.length + 1,
        genre: req.body.genre
    }
    genres.push(genre);
    res.send(genres);
})

router.put('/:id', (req, res) => {
    const genre = genres.find(g => g.id === parseInt(req.params.id));
    if(!genre) return res.status(400).send(`The ganre with given ID ${req.params.id} was not found`);
    const result = validateGenre(req.body);
    if(result.error) return res.status(400).send(result.error.details[0].message);
    genre.genre = req.body.genre;
    res.send(genres);
})

router.delete('/:id', (req, res) => {
    const genre = genres.find(g => g.id === parseInt(req.params.id));
    if(!genre) return res.status(400).send(`The genre with the given ID ${req.params.id} was not found`);
    const index = genres.indexOf(genre);
    genres.splice(index, 1);
    res.send(genres);
})
function validateGenre(genre) {
    const schema = {
        genre: Joi.string().min(3).required()
    }
     return Joi.validate(genre, schema);
}

module.exports = router;