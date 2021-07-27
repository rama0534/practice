const express = require('express');
const Joi = require('joi');
const app = express();
app.use(express.json());

const genres = [
    {id:1, name:"Romance"},
    {id:2, name:"Action"},
    {id:3, name:"Drama"},
    {id:4, name:"Horror"},
]

app.get('/api/genres', (req, res) => {
    res.send(genres);
});

app.get('/api/genres/:id', (req, res) => {
    const genre = genres.find(g => g.id === parseInt(req.params.id));
    if(!genre) return res.status(400).send(`The requested genre with given   ${req.params.id} was not found.`);
    res.send(genre);
});

app.post('/api/genres', (req, res) => {
    const result = validateGenre(req.body);
    if(result.error) return res.status(400).send(result.error.details[0].message);
    const genre = {
        id: genres.length + 1,
        genre: req.body.name
    }
    genres.push(genre);
    res.send(genres);
})

app.put('/api/genres/:id', (req, res) => {
    const genre = genres.find(g => g.id === parseInt(req.params.id));
    if(!genre) return res.status(400).send(`The ganre with given ID ${req.params.id} was not found`);
    const result = validateGenre(req.body);
    if(result.error) return res.status(400).send(result.error.details[0].message);
    genre.name = req.body.name;
    res.send(genres);
})

app.delete('/api/genres/:id', (req, res) => {
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

app.listen(3000, () => console.log("Listening on port 3000.."));
