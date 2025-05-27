const mongoose = require('mongoose')

const movieSchema = new mongoose.Schema({
    id: { type: Number, required: true, unique: true },
    name: { type: String, required: true },
    date: { type: Number },
    tagline: { type: String },
    description: { type: String },
    minute: { type: Number },
    rating: { type: Number }
});

module.exports = mongoose.model('Movie', movieSchema);