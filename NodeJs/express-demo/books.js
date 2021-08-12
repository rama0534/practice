const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...', err));

const Author = mongoose.model('Author', new mongoose.Schema({
  name: String,
  bio: String,
  website: String
}));

const Book = mongoose.model('Book', new mongoose.Schema({
  name: String,
  author: {
    type: mongoose.Schema.Types.ObjectId,
    ref:'Author'
  }
}));

async function createAuthor(name, bio, website) { 
  const author = new Author({
    name, 
    bio, 
    website 
  });

  const result = await author.save();
  console.log(result);
}

async function createBook(name, author) {
  const book = new Book({
    name, 
    author
  }); 
  
  const result = await book.save();
  console.log(result);
}

async function listBook() { 
  const books = await Book
    .find()
    .populate('author', 'name -_id')
    // .populate('category', 'name')
    .select('name author');
  console.log(books);
}

// createAuthor('Rama', 'My bio', 'My Website');

// createBook('Node Book', '610e0d9260258b7efbf47572')

listBook();