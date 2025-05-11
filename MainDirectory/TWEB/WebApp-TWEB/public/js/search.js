document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('search-form');

    form.addEventListener('submit', async function(event) {
        event.preventDefault();

        const title = document.getElementById('title').value;
        const genre = document.getElementById('genre').value;
        const rating = document.getElementById('rating').value;

        const params = new URLSearchParams({ title, genre, rating });

        const response = await fetch(`/movies/search/results?${params.toString()}`);
        const movies = await response.json();

        const container = document.getElementById('results-container');
        container.innerHTML = '';

        if (movies.length === 0) {
            container.innerHTML = '<p class="text-white mt-3">No movies found.</p>';
        } else {
            movies.forEach(movie => {
                const div = document.createElement('div');
                div.classList.add('bg-dark', 'text-white', 'p-3', 'my-2', 'rounded');
                div.innerHTML = `
                    <a href="/movies/${movie.id}" class="text-warning text-decoration-none">
                        <h4>${movie.name} (${movie.date})</h4>
                    </a>
                    <p>Rating: ${movie.rating}</p>
                `;
                container.appendChild(div);
            });
        }
    });
});
