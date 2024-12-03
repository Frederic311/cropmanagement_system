package com.group2.cropmanagement.service;

import Group1.Crop_Management.DTO.UserDTO;
import Group1.Crop_Management.Model.User;

import java.util.List;

public interface UserService {
	
	User save (UserDTO userDTO);

	User getUser(Long id);

	List<User> getAllUsers();

	User updateUser(Long id, UserDTO userDTO);
	void deleteUser(Long id);


	

}
