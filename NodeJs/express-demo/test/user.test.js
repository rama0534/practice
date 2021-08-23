const { User } = require('../models/user')
const config = require('config'); 
const mongoose = require('mongoose');
const jwt = require('jsonwebtoken')

describe('user generateAuthToken', () => {
    it('should return valid JWT token', () => {
         const payload = {
             _id: mongoose.Types.ObjectId().toHexString(),
             isAdmin: true
         };
         const user = new User(payload);
         const token = user.generateAuthToken();
         const decode = jwt.verify(token, config.get('jwtPrivateKey'));
         expect(decode).toMatchObject(payload);
    });
});