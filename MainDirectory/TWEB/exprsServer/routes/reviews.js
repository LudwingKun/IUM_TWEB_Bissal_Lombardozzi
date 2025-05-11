const express = require('express');
const router = express.Router();
const Review = require('../models/reviews');

// Route: GET /reviews?movie_title=NomeDelFilm
router.get('/', async (req, res) => {
    const movieTitle = req.query.movie_title;

    console.log('Queryyyy:', movieTitle);
    if (!movieTitle) {
        return res.status(400).json({ message: 'Parametro movie_title mancante' });
    }

    try {
        console.log('Invio richiesta al servizio recensioni con query:', req.query);
        const reviews = await Review.find({ movie_title: movieTitle });
        console.log('Recensioni:', reviews);
        if (reviews.length > 0) {
            res.json(reviews);
        } else {
            res.json([]);
        }
    } catch (error) {
        console.error('Errore nel recupero delle recensioni:', error);
        res.status(500).json({ message: 'Errore del server' });
    }
});

module.exports = router;
