 const func = require('joi/lib/types/func');
const mongoose = require('mongoose');

 mongoose.connect('mongodb://localhost/playground', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('Connected to MongoDB'))
    .catch(err => console.log('Could not conncted to MongoDB', err));

const CourseSchema = new mongoose.Schema({
        name: {type:String, required:true},
        isPublished: Boolean,
        author: {type:String, required:function(){ return this.isPublished}},
        // tags: {
        //     type:Array,
        //     required:true,
        //     validate: {
        //         validator: function(v){
        //             return v && v.legth >0;
        //         }, message: 'A course should have atleast one tag.'
        //     }
        // },
        // Async
        tags: {
            type: Array,
            required:true,
            validate: {
                isAsync: true,
                validator: function(v, callback){
                    setTimeout(() => {
                        const result = v && v.length > 0;
                        callback(result);
                    }, 4000);
                },
                message: 'A course should have atleast one TAG'
            }
        },
        category: {
            type: String,
            required: true,
            enum: ['Web', 'mobile', 'network']
        },
        date: { type:Date, default:Date.now}
    });
const Course = mongoose.model('Course', CourseSchema);

async function createCourse() {
    try{
        const course = new Course({
            name: 'ReactJS Course',
            isPublished: true,
            author: 'Rama',
            category: 'Web',
            // tags: ['React', 'frontend']
        });
    
        const result = await course.save();
        console.log(result);
    }
    catch(err){
        console.log(err.message);

    }
}
async function getCourses() {
    try{
        const courses = await Course
                    .find({author:'Rama', isPublished:true})
                    .limit(10)
                    .sort({name:1})
                    .select({name:1, tags:1});
        console.log(courses);
    }
    catch(err){
        console.log("Error", error.message);
    }
}

async function updateUser(id) {
    try{
        const course = await Course.findById(id);
        if(!course) return;
        course.author = 'Another Author';
        course.isPublished = true;
        console.log(course);
    }
    catch(err) {
        console.log("Error", err);
    }
}

async function update(id){
    try{
        const result = await Course.update({_id:id}, {
            $set: {
                author:'Nayudu',
                isPublished: true
            }
        }); 
        console.log(result);    
    }
    catch(err){
        console.log("Error", err);
    }
}



async function updateSecondMethod(id){
    try{
        const course = await Course.findByIdAndUpdate(id, {
            $set: {
                author:'Rama Nayudu',
                isPublished: true
            }
        }, {new : true}); 
        console.log(course);    
    }
    catch(err){
        console.log("Error", err);
    }
}

async function removeCourse(id){
    const result = await Course.deleteOne({_id:id});
    console.log(result);
}

async function removeCourseMethodTwo(id){
    const course = await Course.findByIdAndDelete(id);
    console.log(course);
}

// removeCourseMethodTwo('6108c0cc8c5b664514a21cc9');



// removeCourse('6108c0cc8c5b664514a21cc9');

createCourse();

// getCourses();

// updateUser('6108c0cc8c5b664514a21cc9');
// update('6108c0cc8c5b664514a21cc9');
// updateSecondMethod('6108c0cc8c5b664514a21cc9');