package com.group2.cropmanagement.service.impl;

import Group1.Crop_Management.DTO.UserDTO;
import Group1.Crop_Management.Model.User;
import Group1.Crop_Management.Repository.UserRepository;
import Group1.Crop_Management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDTO userDTO) {
		User user = new User(userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()) , "USER", userDTO.getFullname());
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return List.of();
	}

	@Override
	public User updateUser(Long id, UserDTO userDTO) {
		return null;
	}

	@Override
	public void deleteUser(Long id) {

	}

}
