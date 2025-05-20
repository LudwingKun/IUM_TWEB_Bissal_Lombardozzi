var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');


var indexRouter = require('./routes');
var usersRouter = require('./routes/users');
var movieRouter = require('./routes/movies');
var actorsRouter = require('./routes/actors');
var reviewsRouter = require('./routes/reviews');
var oscarsRouter = require('./routes/oscars');

var app = express();
app.use('/public', express.static(path.join(__dirname, 'public')))

// view engine setup
app.set('views', path.join(__dirname, 'views'));

app.set('view engine', 'hbs');
app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());

app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/movies', movieRouter);
app.use('/actors', actorsRouter);
app.use('/reviews', reviewsRouter);
app.use('/oscars', oscarsRouter);

const hbs = require('hbs');

hbs.registerHelper('isArray', function(value) {
  return Array.isArray(value);
});

hbs.registerHelper('encodeURI', str => encodeURIComponent(str));

hbs.registerHelper('ifEquals', function (a, b, options) {
  return a == b ? options.fn(this) : options.inverse(this);
});

hbs.registerHelper('add', (a, b) => a + b);

hbs.registerHelper('subtract', (a, b) => a - b);

hbs.registerHelper('range', function(from, to, options) {
  let result = '';
  for (let i = from; i <= to; i++) {
    result += options.fn(i);
  }
  return result;
});

hbs.registerHelper('gt', function(a, b, options) {
  if (typeof options === 'object' && typeof options.fn === 'function') {
    return a > b ? options.fn(this) : options.inverse(this);
  } else {
    return a > b;
  }
});
hbs.registerHelper('lt', function(a, b, options) {
  return a < b;
});
hbs.registerHelper('queryString', function(params, page) {
  const query = new URLSearchParams({...params, page}).toString();
  return `?${query}`;
});


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  console.log(" SEI TU VERO ????404");
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});


module.exports = app;
