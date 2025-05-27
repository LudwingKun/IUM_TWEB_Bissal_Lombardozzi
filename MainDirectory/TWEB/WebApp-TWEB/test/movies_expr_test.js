const express = require('express');
const axios = require('axios');

const app = express();
const port = 3002;
// Endpoint per recuperare i film
app.get('/api/movies', async (req, res) => {
    const { year, ratingMin, limit } = req.query;

    try {
        // Costruisci la query da passare al server Spring Boot sulla porta 8082
        const response = await axios.get('http://localhost:8082/movies/search', {
            params: {
                year,        // Anno dei film
                ratingMin,   // Rating minimo
                limit        // Limite dei risultati
            }
        });

        // Invia la risposta al client
        res.json(response.data);
    } catch (error) {
        console.error('Errore nel recupero dei film:', error.message);
        res.status(500).json({ message: 'Errore nel recupero dei film' });
    }
});

app.listen(port, () => {
    console.log(`Server Express in ascolto sulla porta ${port}`);
});
