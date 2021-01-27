import express from 'express';
const articleInfo = {
    'learn-react' : {
        upvotes: 0,
        comments: [],
    },
    'learn-node' :{
        upvotes: 0,
        comments: [],
    },
    'my-thoughts-on-resumes' : {
        upvotes: 0,
        comments: [],
    },
}
const app = express();
app.use(express.json());
app.post('/api/articles/:name/upvote', (req, res) => {
    const articleName = req.params.name;
    articleInfo[articleName].upvotes += 1;
    res.status(200).send(`${articleName} now has ${articleInfo[articleName].upvotes} upvotes`);
})
app.post('/api/articles/:name/add-comment',(req, res) => {
    const { username, text } = req.body;
    const articleName = req.params.name;
    articleInfo[articleName].comments.push({ username, text });
    res.status(200).send(articleInfo[articleName]);
})
app.listen(8000, () => console.log('Listening on port 8080'));