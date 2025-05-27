var express = require('express');
var router = express.Router();
var axios = require('axios');


/* GET home page. */
router.get('/', async function(req, res, next) {
    try {
        const index_data = await axios.get('http://localhost:8082/index-data');
        console.log('Index data:', index_data.data);
        const topMovies = index_data.data.bestMovies || [];
        const suggestedMovies = index_data.data.suggestedMovies || [];
        const latestOscars = index_data.data.last5editions || [];

        res.render('index', { title: 'MovieHub', topMovies: topMovies , latestOscars: latestOscars, suggestedMovies: suggestedMovies});
    } catch (error) {
        console.error('Error:', error);
        res.status(500).send('Error loading top movies');
    }
});

module.exports = router;
