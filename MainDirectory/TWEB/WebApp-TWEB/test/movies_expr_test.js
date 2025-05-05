const axios = require('axios');

async function testGetMovies() {
    try {
        const response = await axios.get('http://localhost:3002/api/movies', {
            params: {
                year: 2023,
                ratingMin: 4,
                limit: 10
            }
        });

        const movies = response.data.results;

        console.log(` Film trovati: ${movies.length}`);
        movies.forEach((movie, i) => {
            console.log(`${i + 1}. ${movie.name} (${movie.date}) - Rating: ${movie.rating}`);
        });

    } catch (error) {
        console.error(' Errore nella richiesta:', error.message);
        if (error.response) {
            console.error('Dettagli:', error.response.data);
        }
    }
}

testGetMovies();
