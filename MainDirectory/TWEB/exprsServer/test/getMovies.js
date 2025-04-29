const mongoose = require('mongoose');
const Movie = require('../models/movies');

/**
 * Test connection to the database and extract the first 100 movies of the database
 * @type {string}
 */
const MONGODB_URI = 'mongodb://localhost:27017/iumtweb';
mongoose.connect(MONGODB_URI)
    .then(async () => {
        console.log('✅ Connessione al database riuscita.');
        //query no sql
        const movies = await Movie.find(undefined, undefined, undefined).limit(100);

        console.log(`🎬 Trovati ${movies.length} film:\n`);
        movies.forEach((movie, i) => {
            console.log(`${i + 1}. ${movie.name} (${movie.date}) - ⭐ ${movie.rating} - minute: ${movie.minute}`);
        });
        await mongoose.connection.close();
    })
    .catch(err => {
        console.error('❌ Errore nella connessione al database:', err.message);
    });
