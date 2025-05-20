const express = require('express');
const axios = require('axios');
const router = express.Router();
router.get('/actors/name', async (req, res) => {
    const actorName = req.query.name; // oppure req.params.name se usi /:name

    try {
        const response = await axios.get(`http://localhost:8082/actors/${encodeURIComponent(actorName)}/movies`);

        const movies = response.data;

        res.render('actor-movies', {
            name: actorName,
            movies: movies
        });
    } catch (error) {
        console.error(`Errore durante il recupero dei film dell’attore: ${error.message}`);
        res.status(404).render('actor-movies', {
            name: actorName,
            movies: []
        });
    }
});


module.exports = router;
