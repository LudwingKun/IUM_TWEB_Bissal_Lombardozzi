var express = require('express');
var router = express.Router();
var axios = require('axios');


/* GET home page. */
router.get('/', async function(req, res, next) {
    try {
        const response = await axios.get('http://localhost:8082/movies/top5movies');
        const topMovies = response.data;
        console.log(topMovies);
        res.render('index', { title: 'MovieHub', topMovies: topMovies });
    } catch (error) {
        console.error('Error:', error);
        res.status(500).send('Error loading top movies');
    }
});

module.exports = router;
