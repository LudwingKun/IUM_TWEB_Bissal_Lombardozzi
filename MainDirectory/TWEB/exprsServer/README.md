# README

### Configuration
- Create a local database in mongo at the following address: 'mongodb://localhost:27017/iumtweb'
- inside the 'iumtweb' database, add the collections required:
  - movies
  - reviews
- start mongo if not already started
### Models
Inside the models directory we define the schema of the collections in the database
### Test
Inside the directory 'test' there are a few JavaScript files that test the connection to the 
database and query it. The tests are standalone and can be run directly.
- getMovies: it finds the first 100 movies of the collections (movies)
- getReviews: it finds the first 100 reviews of the collections (reviews)

### Run the server
- run app.js, the server will start on port 3002
- go to http://localhost:3002/
- you can now query the database for example: http://localhost:3002/api/movies?year=2023&limit=10&order=desc
  - the query parameters are:
    - year: the year of the movie
    - ratingMin: the minimum rating of the movie
    - ratingMax: the maximum rating of the movie
    - name: the title of the movie
    - minDuration: the duration of the movie
    - limit: the number of results to return
    - sort: the field to sort by (default: rating)
    - order: the order of the results (asc or desc)
- the server will return the results in JSON format