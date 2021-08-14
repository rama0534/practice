const express = require('express');
const Fawn = require('fawn');
const { Customer } = require('../models/customer');
const { Movie } = require('../models/movie')
const mongoose = require('mongoose');
const router = express.Router();
const { Rental, validateRental } = require('../models/rental');
Fawn.init(mongoose);

router.get('/', async(req, res) => {
    const rentals = await Rental.find();
    res.send(rentals);
});

router.post('/', async(req, res) => {
    try{
        const result = validateRental(req.body);
        if(result.error) return res.status(400).send(result.error.details[0].message);
        const customer = await Customer.findById(req.body.customerId);
        if(!customer) return res.status(404).send(`The given Customer Id ${req.body.customerId} was not found.`);
        const movie = await Movie.findById(req.body.movieId);
        if(!movie) return res.status(404).send(`The given movie Id ${req.body.movieId} was not found.`);
        if(movie.numberInstock === 0) return res.status(400).send( `Requested movie ${req.body.movieId} ${movie.name} not available in stack`);
        let rentals = new Rental({
            customer: {
                _id: customer._id,
                name: customer.name,
                phone: customer.phone
            },
            movie: {
                _id: movie._id,
                title: movie.title,
                dailyRentalRate: movie.dayRentalRate 
            }
        });
        // rentals = await rentals.save();
        // movie.numberInstock--;
        // movie.save();
        // res.send(rentals);
        new Fawn.Task()
            .save('rentals', rentals)
            .update('movies', {_id:movie._id}, { $inc: { numberInstock: -1 }})
            .run()
        res.send(rentals);
    }catch(err){
        console.log("Error", err);
    }
});

router.get('/:id', async(req, res) => {
    try{
        const rental = await Rental.findById(req.params.id);
        if(!rental) return res.status(400).send(result.error.details[0].message);
        res.send(rental);
    }catch(err){
        console.log("Error", err);
    }
});
router.delete('/:id', async(req, res) => {
    try{
        const rental = await Rental.findByIdAndDelete(req.params.id);
        if(!rental) return res.status(404).send(`The record with given rental id ${req.params.id} was not found.`);
        res.send("Success")

    }catch(err){
        console.log("Error", err)
    }
})

module.exports = router;