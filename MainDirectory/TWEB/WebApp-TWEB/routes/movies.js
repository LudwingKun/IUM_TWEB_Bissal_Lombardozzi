const express = require('express');
const router = express.Router();
const axios = require('axios');


router.get('/', async (req, res) => {
    res.send('Hello from movies');
});

router.get('/filters', async (req, res) => {
    try {
        const response = await axios.get('http://localhost:3002/api/movies', {
            params: req.query
        });

        const results = response.data.results || response.data;
        res.render('movies_list', { movies: results });

    } catch (error) {
        console.error(error);
        res.status(500).send('Errore nella ricerca dei film');
    }
});

router.get('/:id', async (req, res) => {
    const id = req.params.id;
    try {
        //get movie_info
        const response = await axios.get(`http://localhost:8082/movies/${id}`);
        const movie = response.data;
        //get posterLink
        const linkResponse = await axios.get(`http://localhost:8082/posters/${id}`);
        const posterLink = linkResponse.data.link;

        console.log(movie);
        res.render('movie_info', { movie, posterLink });
    } catch (error) {
        console.error('Errore durante la richiesta:', error.message);
        if (error.response) {
            console.error('Status:', error.response.status);
            console.error('Data:', error.response.data);
        }
        res.status(500).send('Errore nel recupero del film');
    }
});


module.exports = router;