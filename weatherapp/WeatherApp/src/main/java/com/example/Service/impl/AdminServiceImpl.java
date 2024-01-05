package com.example.Service.impl;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Dto.AdminDTO;
import com.example.Entity.Admin;
import com.example.Entity.User;
import com.example.Repository.AdminRepo;
import com.example.Repository.UserRepo;
import com.example.Service.AdminService;


import jakarta.transaction.Transactional;


@Service
public class AdminServiceImpl implements AdminService {
	
//	private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void deleteUser(int userId) {
    	 System.out.println("Deleting user with ID: " + userId);
        userRepo.deleteById(userId);
    }
    

    @Override
    public boolean authenticateAdmin(Admin admin, String password) {
        return admin != null && passwordEncoder.matches(password, admin.getPassword());
    }
    
    @Override
    public Admin findAdminByUsername(String username) {
        return adminRepo.findByUsername(username).orElse(null);
    }
       
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public void registerAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminRepo.save(admin);
    }

}


