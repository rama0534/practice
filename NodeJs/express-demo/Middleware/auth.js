const Jwt = require('jsonwebtoken');
const config = require('config');
module.exports = function (req, res, next) {
    const token = req.header('x-auth-token');
    if(!token) return res.status(401).send("Token not provided");
    try{
        const decode =  Jwt.verify(token, config.get('jwtPrivateKey'));
        req.user = decode;
        next();
    }
    catch(ex){
        res.status(400).send("Invalied Token");
    }

};


