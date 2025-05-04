const express = require('express');
const router = express.Router();
const axios = require('axios');


router.get('/', async (req, res) => {
    res.send('Hello from movies');
});


router.get('/:id', async (req, res) => {
    const id = req.params.id;
    try {
        const response = await axios.get(`http://localhost:8082/movies/${id}`);
        const movie = response.data;
        console.log(movie);
        res.render('movie_info', { movie });
    } catch (error) {
        res.status(500).send('Errore nel recupero del film');
    }
});

module.exports = router;