const Joi = require('joi');
const mongoose = require('mongoose');


const customerSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        minlength: 3,
        maxlength: 25
    },
    phone: {
        type: String,
        required: true,
        minlength: 5,
        maxlength: 25
    },
    isGold: {
        type: Boolean,
        default:false
    }
});

const Customer = mongoose.model('Customer', customerSchema);

function validateCustomer(customer) {
    const schema = {
        name: Joi.string().min(3).max(25).required(),
        phone: Joi.string().min(10).max(25).required(),
        isGold: Joi.boolean()
    }
     return Joi.validate(customer, schema);
}

exports.Customer = Customer;
exports.validateCustomer = validateCustomer;