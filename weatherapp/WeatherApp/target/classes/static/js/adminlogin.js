function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const data = {
        username: username,
        password: password
    };

    fetch('/admin/authenticate', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Response from server:', data);

        if (data.status) {
            alert(data.message); // Optional: Show a success message
            window.location.href = '/admindashboard.html'; // Redirect upon successful login
        } else {
            alert(data.message); // Show an error message
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred. Please check the console for details.');
    });
}

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    login();
});
