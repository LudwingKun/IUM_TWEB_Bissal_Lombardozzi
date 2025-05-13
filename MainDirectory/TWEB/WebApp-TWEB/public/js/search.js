

document.getElementById("search-form").addEventListener("submit", async function (e) {
    e.preventDefault();

    const title = document.getElementById("title").value;
    const genre = document.getElementById("genre").value;
    const year = document.getElementById("year").value;
    const rating = document.getElementById("rating").value;
    const sort = document.getElementById("sort").value;
    const params = new URLSearchParams({
        title, genre, year, rating, sort
    });

    const response = await fetch(`/movies/search?${params.toString()}`);

    const data = await response.json();
    console.log("FUNZIONA ??");
    console.log(data[0]);
    const container = document.getElementById("results-container");
    container.innerHTML = "";

    if (data.length === 0) {
        container.innerHTML = "<p class='text-center text-light'>Nessun risultato trovato.</p>";
        return;
    }

    const row = document.createElement("div");
    row.className = "row row-cols-1 row-cols-md-3 g-4";

    data.forEach(film => {
        const col = document.createElement("div");
        col.className = "col";

        const card = `
            <div class="card bg-dark text-white h-100 border-light shadow">
                <img src="${film.filmPoster || 'https://via.placeholder.com/300x400'}" class="card-img-top" alt="${film.filmName}">
                <div class="card-body">
                    <h5 class="card-title">${film.filmName}</h5>
                    <p class="card-text">
                        <strong>Genere:</strong> ${film.filmGenres || 'N/A'}<br>
                        <strong>Anno:</strong> ${film.filmDate?.split('-')[0] || 'N/A'}<br>
                        <strong>Rating:</strong> ⭐ ${film.filmRating || 'N/A'}
                    </p>
                </div>
            </div>
        `;

        col.innerHTML = card;
        row.appendChild(col);
    });

    container.appendChild(row);
});

