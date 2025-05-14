const express = require('express');
const router = express.Router();
const axios = require('axios');


router.get('/', async (req, res) => {
    try {
        const response = await axios.get('http://localhost:8082/movies');
        const movies = response.data;
        res.render('movies_list', {movies: movies});

    } catch (error) {
        console.error(error);
        res.status(500).send('Error');
    }
});

/**
 * for filtred movies
 */
router.get('/movies', async (req, res) => {
    const {filmName,  filmDate, rating,  genre } = req.query;

    try {
        const response = await axios.get('http://localhost:8082/movies/search', {
            params: { filmName, filmDate, rating, genre }
        });
        console.log('Dati ricevuti da Spring Boot:', response.data);
        res.render('search', { movies: response.data });
    } catch (error) {
        console.error('Errore nel proxy:', error.message);
        res.status(500).json({ message: 'Errore nel recupero dei film' });
    }
});


router.get('/search', async (req, res) => {
    res.render('search');
});

router.get('/:id', async (req, res) => {
    const id = req.params.id;
    try {
        console.log(`Chiamata a Spring Boot: http://localhost:8082/movies/${id}`);
        //get movie_info
        const response = await axios.get(`http://localhost:8082/movies/${id}`);
        console.log('Response:', response.data);
        const movie = response.data;
        res.render('movie_info', { movie: movie });
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