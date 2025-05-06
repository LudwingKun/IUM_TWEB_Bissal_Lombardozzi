const express = require('express');
const router = express.Router();
const Review = require('../models/reviews');

router.get('/', async (req, res) => {
    const { movieTitle, critic_name, startDate, endDate, keyword, page = 1, limit = 20 } = req.query;
    const filter = {};

    if (movieTitle) {
        filter.movieTitle = new RegExp(movieTitle, 'i'); // case-insensitive
    }

    if (critic_name) {
        filter.critic_name = new RegExp(critic_name, );
    }

    if (startDate || endDate) {
        filter.date = {};
        if (startDate) filter.date.$gte = new Date(startDate);
        if (endDate) filter.date.$lte = new Date(endDate);
    }
   //it is possible to search by keyword on the review content
    if (keyword) {
        filter.content = new RegExp(keyword, 'i');
    }

    try {
        const reviews = await Review.find(filter)
            .skip((page - 1) * limit)
            .limit(parseInt(limit));

        const total = await Review.countDocuments(filter);

        res.json({
            page: parseInt(page),
            limit: parseInt(limit),
            totalResults: total,
            totalPages: Math.ceil(total / limit),
            results: reviews
        });
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Errore durante il recupero delle recensioni' });
    }
});

module.exports = router;
