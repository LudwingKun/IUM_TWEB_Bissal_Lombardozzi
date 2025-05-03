var express = require('express');
var router = express.Router();
var axios = require('axios');


/* GET home page. */
router.get('/', function(req, res, next) {

  axios.get('http://localhost:8082/movies/1011971')
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error('Error:', error);
      });

  res.render('index', { title: 'Express' });
});

module.exports = router;
