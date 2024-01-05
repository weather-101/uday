// admindashboard.js

document.addEventListener('DOMContentLoaded', function () {
    loadUsers();
});

function loadUsers() {
    fetch('/admin/getUsers')
        .then(response => response.json())
        .then(users => {
            displayUsers(users);
        })
        .catch(error => console.error('Error:', error));
}

function displayUsers(users) {
    const userTableBody = document.getElementById('userTableBody');
    userTableBody.innerHTML = ''; // Clear existing rows

    users.forEach(user => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${user.userid}</td>
            <td>${user.username}</td>
            <td><button onclick="deleteUser(${user.userid})">Delete</button></td>
        `;
        userTableBody.appendChild(row);
    });
}

function deleteUser(userid) {
    if (!userid || isNaN(userid) || userid <= 0) {
        alert('Invalid user ID');
        return;
    }

    if (confirm('Are you sure you want to delete this user?')) {
        fetch(`/admin/deleteUser/${userid}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('User deleted successfully');
                loadUsers(); // Refresh the user list after deletion
            } else {
                alert('Failed to delete user');
            }
        })
        .catch(error => console.error('Error:', error));
    }
}
