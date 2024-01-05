package com.example.Service;

import java.util.List;

import com.example.Dto.LoginDTO;
import com.example.Dto.UserDTO;
import com.example.Entity.User;
import com.example.response.LoginResponse;

public interface UserService {

	String addUser(UserDTO userDTO);
	LoginResponse loginUser(LoginDTO loginDTO);
	 List<User> findAllUsers(); 
	 List<String> addMultipleUsers(List<UserDTO> userDTOList);
	 
	 String updateUser(int userId, UserDTO userDTO);

}
