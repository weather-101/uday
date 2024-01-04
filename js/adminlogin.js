function login() {
            const username = document.getElementById('username').value;
            const password = document.getElementById('password').value;
            
            const data = {
                username : "admin",
                password: "admin123"
            };
            
            fetch('admin/authenticate', {
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
                    window.location.href = '/admindashboard.html';
                }
            })
            .catch(error => console.error('Error:', error));
        }
        
        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission
             // Manually trigger the login function
        });
