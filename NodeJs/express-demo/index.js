const express =  require('express'); 
const app = express();

require('./startup/routes')(app);
require('./startup/connectdb')();
require('./startup/loging')();
require('./startup/config')(app);

app.get('/', (req, res) => {
    res.send('Hello world!');
});
// app.use(express.urlencoded({extened: true}));
    app.use(express.static('public'));

const port = process.env.PORT || 3000;
const server = app.listen(port, () => console.log(`Listening on port 3000...`));

module.exports = server;
