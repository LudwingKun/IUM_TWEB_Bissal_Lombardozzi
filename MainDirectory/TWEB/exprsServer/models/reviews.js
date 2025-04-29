const mongoose = require("mongoose");

const reviewsSchema = new mongoose.Schema({
    rotten_tomatoes_link: {type: String, required: true, unique: true},
    movie_title: {type: String, required: true},
    critic_name: {type: String},
    top_critic: {type: Boolean},
    publisher_name: {type: String},
    review_type: {type: String},
    review_date: {type: Date},
    review_content: {type: String}
});

module.exports = mongoose.model('Review', reviewsSchema);