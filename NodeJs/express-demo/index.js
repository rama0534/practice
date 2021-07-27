const { json } = require('express');
const express =  require('express');
const Joi = require('joi');
const func = require('joi/lib/types/func');
const app = express();
app.use(express.json());

const courses = [
    {id:1, name:"course1" },
    {id:2, name:"course2" },
    {id:3, name:"course3" }
]

app.get('/', (req, res) => {
    res.send('Hello world!');
});

app.get('/api/courses', (req, res) => {
    res.send(res.send(courses));
});

app.get('/api/courses/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id));
    if(!course) return res.status(404).send('The course with the given ID was not found');
    res.send(course);
});

app.post('/api/courses', (req, res) => {
    const result = validateCourse(req.body)
    if(result.error) return res.status(400).send(result.error.details[0].message);
    const course = {
        id: courses.length +1,
        name: req.body.name
    };
    courses.push(course);
    res.send(courses);
});

app.put('/api/courses/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id));
    if(!course) return res.status(400).send('The course with given ID was not found');
    const result = validateCourse(req.body)
    if(result.error) return res.status(400).send(result.error.details[0].message);
    course.name = req.body.name;
    res.send(course);
})

app.delete('/api/courses/:id', (req, res) => {
    const course = courses.find(c => c.id === parseInt(req.params.id));
    if(!course) return res.status(400).send('The course with given ID was not found');
    // course = findCourse(req.params);
    // if(!course) return res.status(400).send('the course with the given ID was not found');
    const index = courses.indexOf(course);
    courses.splice(index, 1);
    res.send(courses);

})

// function findCourse(params) {
//     console.log(params);
//     const course = courses.find(c => c.id === parseInt(params.id));
//     return course; 
// } 

function validateCourse(course) {
    const schema = {
        name: Joi.string().min(3).required()
    };
    
    return Joi.validate(course, schema);
}

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Listening on port ${port}...`));
