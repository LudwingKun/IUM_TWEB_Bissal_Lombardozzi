const express = require('express');
const router = express.Router();
const Movie = require('../models/movies');
/**
 * dynamic query to get the movies we need
 */
router.get('/', async (req, res) => {
    const { ratingMin, ratingMax,  year, name, minDuration,  page = 1, limit = 20, sort = 'rating', order = 'desc' } = req.query;
    //build the filter with the options received
    const filter = {};

    if (ratingMin) {
        filter.rating = { $gte: parseFloat(ratingMin) };
    }
    if (ratingMax) {
        filter.rating = { $lte: parseFloat(ratingMax) };
    }

    if (year) {
        filter.date = parseInt(year);
    }

    if (name) {
        filter.name = new RegExp(name, 'i'); // case-insensitive
    }
    if (minDuration) {
        filter.minute = { $gte: parseInt(minDuration) };
    }
    //sort the results
    const sortOption = {};
    sortOption[sort] = order === 'asc' ? 1 : -1;

    try {
        const movies = await Movie.find(filter)
            .sort(sortOption)
            .skip((parseInt(page) - 1) * parseInt(limit))
            .limit(parseInt(limit));

        const total = await Movie.countDocuments(filter);

        res.json({
            page: parseInt(page),
            limit: parseInt(limit),
            totalResults: total,
            totalPages: Math.ceil(total / limit),
            results: movies
        });
    } catch (err) {
        res.status(500).json({ error: 'Error during the query on movies' });
    }
});

module.exports = router;
