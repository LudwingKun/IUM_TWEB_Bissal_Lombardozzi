const mongoose = require("mongoose");

const reviewsSchema = new mongoose.Schema({
    _id: {type: Object, auto: true},
    movie_title: {type: String, required: true},
    critic_name: {type: String},
    top_critic: {type: Boolean},
    publisher_name: {type: String},
    review_type: {type: String},
    review_date: {type: Date},
    review_content: {type: String},
    rotten_tomatoes_link: {type: String, required: true, unique: true},
});

module.exports = mongoose.model('Review', reviewsSchema);