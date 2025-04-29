const mongoose = require('mongoose');
//The URL which will be queried. Run "mongod.exe" for this to connect
//var url = 'mongodb://localhost:27017/test';
const mongoDB = 'mongodb://localhost:27017/iumtweb';
mongoose.Promise = global.Promise;
connection = mongoose.connect(mongoDB, {
    checkServerIdentity: false,
})
    .then(() => {
        console.log('connection to mongodb worked!');
    })
    .catch((error) => {
        console.log('connection to mongodb did not work! ' + JSON.stringify(error));
    });
module.exports = mongoose.connection