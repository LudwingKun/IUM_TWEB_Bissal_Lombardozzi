const mongoose = require('mongoose');
const db = require("../database/db");
const Review = require("../models/reviews");

db.once('open', async () => {
    console.log("✅ Connessione aperta, sto estraendo dati...");

    const reviews = await Review.find().limit(100);
    reviews.forEach((r, i) => console.log(`${i + 1}. ${r.movie_title} - ${r.critic_name}`));

    mongoose.connection.close();
});