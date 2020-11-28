// import React from 'react';
// import ReactDOM from 'react-dom';

const person = {
    name: "Rama",
    walk() {
        console.log(this);
    }
};
console.log("Hello World");
person.walk();

const talk = person.walk.bind(person);
talk();

//Arrow Function
const squeare = function(number) {
    return number * number;
}

const squr = num => num * num;

console.log(squeare(5));
console.log(squr(10));

//Arrow Function
const jobs = [
    {id:1, isActive:true},
    {id:2, isActive:true},
    {id:3, isActive:true},
    {id:4, isActive:false}
];

const activeJobs = jobs.filter(job => job.isActive);

//Array.map Method
//Template literal ``
const colors = ['red', 'green', 'yellow'];
const items = colors.map(function(color){
    return '<li>' + color + '</li>'
});
const itms = colors.map(color => `<li>${color}</li>`);
 
console.log(items);
console.log(itms);

//Object Desructing & Aliance  


const address = {
    street: 'R ',
    city: 'H',
    country: 'I'
};

// const street = address.street;
// const city = address.city;
// const country = address.country;

// console.log(country);

const {street:st, city:ci, country:coun} = address;
console.log(st);

//spread operator 

const first = [1, 2, 3];
const second = [4, 5, 6];

const combine = first.concat(second);
console.log(combine);

const combine2 = [...first, 'a', ...second, 'b'];
console.log(combine2);


const firstName = {name: 'Rama'};
const position = {job: 'intern'};

const combine3 = {...firstName, ...position, location:'Australia'};
console.log(combine3);

//Classes and inheritance
class Person {
    constructor(name){
        this.name = name;
    }
    walk(){
        console.log("walk");
    }
}
class Teacher {
    teach() {
        console.log("teach");
    }
}