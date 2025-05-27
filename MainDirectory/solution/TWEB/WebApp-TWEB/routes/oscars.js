const express = require('express');
const router = express.Router();
const axios = require('axios');

router.get('/edition/:edition', async function(req, res, next) {
    try {
        const edition = req.params.edition;
        const response = await axios.get(`http://localhost:8082/oscars/edition/${edition}`);
        const oscar_ceremony = response.data;
        console.log(oscar_ceremony);
        res.render('oscar_awards_ceremony', {oscar_ceremony: oscar_ceremony});
    } catch (error) {
        console.error('Error:', error);
        res.status(500).send('Error loading the oscar ceremony');
    }
});

router.get('/year/:year', async function(req, res, next) {
    try {
        const year = req.params.year;
        const response = await axios.get(`http://localhost:8082/oscars/year/${year}`);
        const oscar_ceremony = response.data;
        console.log(oscar_ceremony);
        res.render('oscar_awards_ceremony', {oscar_ceremony: oscar_ceremony});
    } catch (error) {
        console.error('Error:', error);
        res.status(500).send('Error loading the oscar ceremony');
    }
});


module.exports = router;