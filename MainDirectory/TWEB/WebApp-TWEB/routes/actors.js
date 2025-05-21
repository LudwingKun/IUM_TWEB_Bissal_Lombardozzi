const express = require('express');
const axios = require('axios');
const router = express.Router();
router.get('/:name', async (req, res) => {
    const actorName = req.params.name; // oppure req.params.name se usi /:name
    console.log(`Chiamata a Spring Boot: http://localhost:8082/actors/${encodeURIComponent(actorName)}/movies`);
    try {
        const response = await axios.get(`http://localhost:8082/actors/${encodeURIComponent(actorName)}/movies`);
        console.log('OK - Dati ricevuti da Spring Boot:', response.data);

        const { movies, oscarAwards, name: returnedName, numberOfOscars } = response.data;
        res.render('actor_movies', {
            name: returnedName,
            movies: movies,
            oscars: oscarAwards,
            totalOscars: numberOfOscars
        });
    } catch (error) {
        console.error(`Errore durante il recupero dei film dell’attore: ${error.message}`);
        res.status(404).render('actor_movies', {
            name: actorName,
            movies: [],
            oscars: [],
            totalOscars: 0
        });
    }
/*    try {
        const response = await axios.get(`http://localhost:8082/actors/${encodeURIComponent(actorName)}/movies`);
        console.log('OK - Dati ricevuti da Spring Boot:');
        const movies = response.data;

        res.render('actor_movies', {
            name: actorName,
            movies: movies,
            oscars: oscars
        });
    } catch (error) {
        console.error(`Errore durante il recupero dei film dell’attore: ${error.message}`);
        res.status(404).render('actor-movies', {
            name: actorName,
            movies: []
        });
    }*/
});


module.exports = router;
