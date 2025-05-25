const socket = io();
const movieTitle = document.getElementById('chat-box').dataset.movie;

socket.emit('joinRoom', movieTitle);

document.getElementById('chat-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const message = document.getElementById('chat-input').value.trim();
    if (message.length === 0) return;

    const username = 'A random user';
    socket.emit('chatMessage', { movieTitle, username, message });
    document.getElementById('chat-input').value = '';
});

socket.on('message', ({ username, message }) => {
    const messages = document.getElementById('messages');
    const msgElement = document.createElement('div');
    msgElement.textContent = `${username}: ${message}`;
    messages.appendChild(msgElement);
    messages.scrollTop = messages.scrollHeight;
});
