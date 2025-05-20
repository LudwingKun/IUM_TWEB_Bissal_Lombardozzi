var express = require('express');
var router = express.Router();
var axios = require('axios');


/* GET home page. */
router.get('/', async function(req, res, next) {
    try {
        const movies = await axios.get('http://localhost:8082/movies/top5movies');
        const topMovies = movies.data;
        const oscars = await axios.get('http://localhost:8082/oscars/latest5');
        const latestOscars = oscars.data;
        console.log(latestOscars);
        res.render('index', { title: 'MovieHub', topMovies: topMovies , latestOscars: latestOscars});
    } catch (error) {
        console.error('Error:', error);
        res.status(500).send('Error loading top movies');
    }
});

module.exports = router;
