const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...', err));

const authorSchema = new mongoose.Schema({
                                              name: String,
                                              bio: String,
                                              website: String
                                            });

const Author = mongoose.model('Author', authorSchema);

const EmbededBook = mongoose.model('EmbededBook', new mongoose.Schema({
                                                                          name: String,
                                                                          authors: {
                                                                            type: [ authorSchema ],
                                                                            required:true
                                                                          }
                                                                        }));

async function createBook(name, authors) {
  const book = new EmbededBook({
    name, 
    authors
  }); 
  
  const result = await book.save();
  console.log(result);
}

async function listBooks() { 
  const books = await EmbededBook.find();
  console.log(books);
}

async function updateAuthor(bookId) {
  const book = await EmbededBook.findById(bookId);
  book.author.name = 'Rama';
  book.save();
}

async function addAuthor(courseId, author){
  const book = await EmbededBook.findById(courseId);
  book.authors.push(author);
  book.save();
}

async function removeAuthor(courseId, authorId){
  const book = await EmbededBook.findById(courseId);
  const author = book.authors.id(authorId);   
  author.remove(); 
  book.save();
}
// createBook('Node Book', [ 
//                           new Author({ name: 'Rama' }),
//                           new Author({ name: 'Nayudu'})
//                         ]);

// updateAuthor('610e1cd998a1e3818c2f1074');
// listBooks();

// addAuthor('610e23188c56c9822bec5521', new Author({ name: 'Sadam' }));

removeAuthor('610e23188c56c9822bec5521', '610e2463fb7ce38271556e10');
