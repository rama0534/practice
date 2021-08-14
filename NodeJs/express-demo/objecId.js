const mongoose = require('mongoose');
const id = new mongoose.Types.ObjectId();
console.log(id.getTimestamp()); 
console.log(mongoose.Types.ObjectId.isValid(id));
console.log(mongoose.Types.ObjectId.isValid('34324'));