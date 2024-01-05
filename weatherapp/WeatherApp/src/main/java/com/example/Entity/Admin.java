package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;

    @Column(name = "username", length = 255)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    public Admin() {
        this.username = "admin";
        this.password = "admin123"; // Password is "admin123"
    }

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
