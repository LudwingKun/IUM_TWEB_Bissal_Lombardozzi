const express = require('express');
const router = express.Router();
const axios = require('axios');


/*
router.get('/', async (req, res) => {
    console.log('Query:', req.query);
    console.log('Sending request to reviews service with query:', req.query);

    try {
        const response = await axios.get('http://localhost:3003/reviews', {
            params: req.query
        });
        let { movie_title } = req.query;
        const reviews = response.data || [];
        console.log('Reviews:', reviews);
        res.render('reviews_list', { reviews, movie_title });
    } catch (error) {
        console.error('Error trying to retrive reviews:', error.message);
        res.status(500).send('Error loading reviews');
    }
})
*/

router.get('/', async (req, res) => {
    let movie_title = req.query.movie_title;

    if (!movie_title) {
        return res.status(400).send('Parametro "movie_title" mancante');
    }

    console.log('Sending request to reviews service with movie_title:', movie_title);

    try {
        const response = await axios.get('http://localhost:3003/reviews', {
            params: {
                movie_title: movie_title
            }
        });

        const reviews = response.data || [];
        console.log('Reviews:', reviews);
        res.render('reviews_list', { reviews, movie_title });
    } catch (error) {
        console.error('Error trying to retrieve reviews:', error.message);
        if (error.response) {
            console.error('Dettagli:', error.response.data);
        }
        res.status(500).send('Error loading reviews');
    }
});

module.exports = router;
