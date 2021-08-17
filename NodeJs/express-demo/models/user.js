const Joi = require('joi');
const mongoose = require('mongoose');
const Jwt = require('jsonwebtoken');
const config = require('config');
mongoose.set('useCreateIndex', true);

const userSchema = new mongoose.Schema({
    name: {
        type: String,
        minlength: 3,
        maxlength: 50,
        required: true
    },
    email: {
        type: String,
        unique: true,
        minlength: 5,
        maxlength: 50
    },
    password: {
        type: String,
        minlength: 8,
        maxlength: 1024,
    },
    isAdmin: Boolean
});

userSchema.methods.generateAuthToken = function () {
    const token = Jwt.sign({_id: this._id, isAdmin: this.isAdmin}, config.get('jwtPrivateKey')); 
    return token;
};

const User = mongoose.model('User', userSchema);
function validateUser(user) {
    const schema = {
        name: Joi.string().min(5).max(50).required(),
        email: Joi.string().min(3).max(50).required().email(),
        password: Joi.string().min(3).max(1024).required(),
    };
    return Joi.validate(user, schema);
}

exports.User = User;
exports.validateUser = validateUser;