const Joi = require('joi');
Joi.objectId = require('joi-objectid')(Joi);
const { required } = require('joi/lib/types/lazy');
const string = require('joi/lib/types/string');
const mongoose = require('mongoose');

const Rental = mongoose.model('Rental', new mongoose.Schema({
    customer: {
        type: new mongoose.Schema({
            name: {
                type: String,
                required: true,
                minlength:3,
                maxlength:25,
                trim:true
            },
            isGold:{
                type: Boolean,
                default: false
            },
            phone:{
                type: String,
                required: true
            }
        }),
        required: true
    },
    movie: {
        type: new mongoose.Schema({
            title:{
                type: String,
                required: true,
                minlength:3,
                maxlength:25,
                trim:true
            },
            dailyRentalRate: {
                type: Number,
                required: true,
                min:1,
                max:25,
            }
        }),
        required: true
    },
    dayOut: {
                type: Date,
                required: true,
                default: Date.now
            },
    dateReturned: {
                type:Date
            },
    rentalFee:{
                type: Number,
                min: 0
            }
}));
function validateRental(rental) {
    const schema = {
                        customerId: Joi.objectId().required(),
                        movieId: Joi.objectId().required()
                    };
    return Joi.validate(rental, schema);
} 

exports.Rental = Rental;
exports.validateRental = validateRental;