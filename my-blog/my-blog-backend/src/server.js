import express from 'express';
const articleInfo = {
    'learn-react' : {
        upvotes: 0,
    },
    'learn-node' :{
        upvotes: 0,
    },
    'my-thoughts-on-resumes' : {
        upvotes: 0,
    },
}
const app = express();
app.use(express.json());

app.get('/hello', (req, res) => res.send('Hello!'));
app.get('/hello/:name', (req, res) => res.send(`Hello ${req.params.name}!`));
app.post('/hello', (req, res) => res.send(`Hello ${req.body.name}!`));

app.listen(8000, () => console.log('Listening on port 8080'));