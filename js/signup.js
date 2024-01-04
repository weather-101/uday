 function signup() {
            const username = document.getElementById('username').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            
            const data = {
                userid: 0, // You may generate the user ID or handle it differently
                username: username,
                email: email,
                password: password
            };
            
            fetch('/save', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.text())
            .then(data => {
                // Handle response from backend (data contains user ID or message)
                alert('User ID: ' + data);
                // Redirect to login page or another page upon successful signup
                window.location.href = '/login.html';
            })
            .catch(error => console.error('Error:', error));
        }
        
        document.getElementById('signupForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission
            // Manually trigger the login function
        });