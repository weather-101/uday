package com.example.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Dto.LoginDTO;
import com.example.Dto.UserDTO;
import com.example.Entity.User;
import com.example.Repository.UserRepo;
import com.example.Service.UserService;
import com.example.response.LoginResponse;
@Service
public class UserIMPL implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public String addUser(UserDTO userDTO) {
		User user = new User(userDTO.getUserid(),userDTO.getUsername(),userDTO.getEmail(), this.passwordEncoder.encode(userDTO.getPassword()));
		userRepo.save(user);
		return user.getUsername();
	}
	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		String msg="";
		User user1=userRepo.findByEmail(loginDTO.getEmail());
		if(user1!=null) {
			String password=loginDTO.getPassword();
			String encodedPassword=user1.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encodedPassword);
			if(isPwdRight) {
				Optional<User> user=userRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
						if(user.isPresent()) {
							return new LoginResponse("Login Success",true);
						}
						else {
							return new LoginResponse("Login Failed",false);
						}
			}
				else {
					return new LoginResponse("Password Not MAtch",false);
				}
		}
				else {
					return new LoginResponse("Email not exists",false);
				}

	}
	@Override
	public List<User> findAllUsers() {
		 return userRepo.findAll();
	}
	@Override
    public List<String> addMultipleUsers(List<UserDTO> userDTOList) {
        List<String> addedUsernames = new ArrayList<>();
        for (UserDTO userDTO : userDTOList) {
            String username = addUser(userDTO);
            addedUsernames.add(username);
        }
        return addedUsernames;
    }
	@Override
    public String updateUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepo.findById(userDTO.getUserid());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            // You may want to check if the password is provided and update it accordingly
            if (userDTO.getPassword() != null) {
                existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            userRepo.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found";
        }
	}
}


