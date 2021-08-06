const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/mongo-exercises', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log("Conneted to Mongoose Database....."))
    .catch(err => console.log("Could not connect to database..", err));


const CourseSchema = new mongoose.Schema({
    name: {type:String, required:true},
    author: String,
    tags:[ String ],
    date: {type:Date, default:Date.now},
    isPublished: Boolean,
    price: Number
})

const Course = mongoose.model('Course', CourseSchema);

async function getCourses(){
    try{
        const courses = await Course
                // .find({price:{$gte:15}}, {isPublished:true})
                .find({isPublished:true})
                .or( [
                        {price:{$gte:15}}, 
                        {name:/.* by .*/ } 
                     ])
                // .or({name:/.* by .*/ })
                .select({name:1, author:1, price:1, isPublished:1});
        console.log(courses);
    }
    catch(err){
        console.log("Error", err);
    }
}


 getCourses();