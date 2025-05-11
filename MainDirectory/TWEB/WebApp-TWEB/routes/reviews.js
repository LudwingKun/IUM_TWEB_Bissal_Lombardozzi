const express = require('express');
const router = express.Router();
const axios = require('axios');


router.get('/', async (req, res) => {
    console.log('Query:', req.query);
    console.log('Sending request to reviews service with query:', req.query);

    try {
        const response = await axios.get('http://localhost:3003/reviews', {
            params: req.query
        });
        const { movie_title } = req.query;
        const reviews = response.data || [];
        console.log('Reviews:', reviews);
        res.render('reviews_list', { reviews, movie_title });
    } catch (error) {
        console.error('Error trying to retrive reviews:', error.message);
        res.status(500).send('Error loading reviews');
    }
})

module.exports = router;
