const express = require('express');
const router = express.Router();
const axios = require('axios');


router.get('/', async (req, res) => {
    try {
        const response = await axios.get('http://localhost:3002/api/reviews', {
            params: req.query
        });

        const reviews = response.data.results || [];
        res.render('reviews_list', { reviews });
    } catch (error) {
        console.error('Error trying to retrive reviews:', error.message);
        res.status(500).send('Error loading reviews');
    }
});

module.exports = router;
