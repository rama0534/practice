const express = require('express');
const router = express.Router();
const { Movie, validateMovie } = require('../models/movie');
const { Genre } = require('../models/genres-mongo')
const auth = require('../Middleware/auth')
router.get('/', async(req, res) => {
    try {
        console.log("Hello world");
        const movies = await Movie.find();
        res.send(movies);
    }
    catch(err){
        console.log("error", err.message);
    }
});

router.post('/', auth, async(req, res) => {
    try {
            const result = validateMovie(req.body);
            if(result.error) return res.status(400).send(result.error.details[0].message);
            const genre = await Genre.findById(req.body.genreId);
            if (!genre) return res.status(400).send('Invalid genre.');
            const movie = new Movie ({
                                        title: req.body.title,
                                        genre: {
                                            _id: genre._id,
                                            name: genre.name
                                        },
                                        numberInstock: req.body.numberInstock,
                                        dayRentalRate: req.body.dayRentalRate
            })
            await movie.save();
            res.send(movie);   
    }
    catch(err){
        console.log("error", err);
    }
});
router.get('/:id', async(req, res) =>{
    try{
        const movie = await Movie.findById(req.params.id);
        if(!movie) return res.status(400).send(`Invalid Movie id: ${req.params.id}`);
        res.send(movie);

    }
    catch(err){
        console.log("Error", err);
    }
});
router.put('/:id', async(req, res) => {
    try{
        const result = validateMovie(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        const genre = await Genre.findById(req.body.genreId);
        if (!genre) return res.status(400).send('Invalid genre.');
        const movie = await Movie.findByIdAndUpdate({_id:req.params.id}, {
                                                                        title: req.body.title,
                                                                        genre: {
                                                                            _id: genre._id,
                                                                            name: genre.name
                                                                        },
                                                                        numberInstock: req.body.numberInstock,
                                                                        dayRentalRate: req.body.dayRentalRate
                                                                    });
        if(!movie) return res.status(400).send(`Invalid Movie id: ${req.params.id}`);
        res.send(movie);
    }
    catch(err){
        console.log("error", err)
    }
});
router.delete('/:id', async(req, res) => {
    try{
        const movie = await Movie.findByIdAndDelete(req.params.id);
        if(!movie) return res.status(404).send(`Movie with the given id: ${req.params.id} was not found`);
        res.send(movie);
    }catch(err){
        console.log("Error", err);
    }
})

module.exports = router;