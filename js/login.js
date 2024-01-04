function login() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;
            
            const data = {
                email: email,
                password: password
            };
            
            fetch('/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                // Handle response from backend (data contains login status)
                alert(data.message);
                if(data.status) {
                    // Redirect to dashboard or another page upon successful login
                    window.location.href = '/dashboard.html';
                }
            })
            .catch(error => console.error('Error:', error));
        }
        
        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission
             // Manually trigger the login function
        });
