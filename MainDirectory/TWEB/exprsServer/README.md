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