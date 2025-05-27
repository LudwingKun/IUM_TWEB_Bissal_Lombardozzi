# README

## Configuration
to start the whole project, we need the three Server online
- in exprsServer run "www"
- in springbootServer start "SpringbootServerApplication"
- in WebApp-TWEB start the "www" file


you can reach the webApp at http://localhost:3000


## Test
The directory "test" contains few tests of connection with the other servers

you can make a request of a list of movies using:
http://localhost:3000/movies/filters?year=2023&ratingMin=3
this will filter movie by year and minimum rating,  there are a lot more parameters that
can be used, consult the README in exprsServer

## Routes
