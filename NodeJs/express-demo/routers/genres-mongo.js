const express = require('express');
const router = express.Router();
const { Genre, validateGenre } = require('../models/genres-mongo');
const auth = require('../Middleware/auth');
const admin = require('../Middleware/admin');
// const asyncMiddleware = require('../middleware/async');

// router.get('/', asyncMiddleware(async(req, res, next) => {
//     const genres = await Genre.find();
//     res.send(genres);
// }));
router.get('/',  async(req, res, next) => {
    // throw new Error('Could not get genre.');
    const genres = await Genre.find();
    res.send(genres);
});
router.get('/:id', async(req, res) => {
    try{
        const genre = await Genre.findById({_id:req.params.id});
        if(!genre) return res.status(400).send(`The requested genre with given   ${req.params.id} was not found.`);
        res.send(genre);
    }
    catch(err){
        console.log("error ", err.message);
    }
});
router.post('/', auth, async(req, res) => {
    try{
        const result = validateGenre(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        let genre = new Genre ({ name: req.body.name })
        genre = await genre.save();
        res.send(genre);
    }
    catch(err){
        console.log("error ", err);
    }
});

router.put('/:id', async(req, res) => {
    try{
        const result = validateGenre(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        const genre = await Genre.findByIdAndUpdate(req.params.id, {name: req.body.name}, {new: true});
        if(!genre) return res.status(400).send(`The ganre with given ID ${req.params.id} was not found`);
        res.send(genre);
    }
    catch(err){
        console.log("error ", err);
    }
});

router.delete('/:id', [auth, admin], async(req, res) => {
    try{
        const genre =  await Genre.findByIdAndRemove(req.params.id);
        if(!genre) return res.status(400).send(`The genre with the given ID ${req.params.id} was not found`);
        res.send(genre);
    }
    catch(err){
        console.log(`Error while deleteing the genre ${req.params.id}`);
    }
});
module.exports = router;