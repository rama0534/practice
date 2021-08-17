const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const Joi = require('joi'); 
const { User } = require('../models/user'); 

router.get('/', (req, res) => {
    res.send("Hello from auth");
});

router.post('/', async(req, res) => {
    const result = validate(req.body);
    if(result.error) return res.status(400).send(result.error.details[0].message);
    const user = await User.findOne({email: req.body.email});
    if(!user) res.status(400).send('Invalied email');
    const valiedPassword = await bcrypt.compare(req.body.password, user.password);
    if(!valiedPassword) return res.status(400).send('password');
    const token = user.generateAuthToken();
    res.send(token);
});

function validate(req){
    const schema = {
        email: Joi.string().min(5).max(50).required(),
        password: Joi.string().min(5).max(50).required()
    }
    return Joi.validate(req, schema);
}

module.exports = router;