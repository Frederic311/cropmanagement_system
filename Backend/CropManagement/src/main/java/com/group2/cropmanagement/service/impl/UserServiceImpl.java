package com.group2.cropmanagement.service.impl;

import com.group2.cropmanagement.dto.SearchDTO;
import com.group2.cropmanagement.dto.UserDTO;
import com.group2.cropmanagement.model.User;
import com.group2.cropmanagement.repository.UserRepository;
import com.group2.cropmanagement.service.UserService;
import com.group2.cropmanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtil jwtService;

	public String generateToken(String email) {
		return jwtService.generateToken(email);
	}

	public void validateToken(String token, UserDetails userDetails) {
		jwtService.validateToken(token, userDetails);
	}

	@Override
	public User getUserFromToken(String token) {
		String email = jwtService.extractUsername(token);

		return userRepository.findByEmail(email);
	}


	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		User existingUserByEmail = userRepository.findByEmail(userDTO.getEmail());
		if (existingUserByEmail != null) {
			throw new IllegalArgumentException("A user with this email already exists.");
		}
		if (userRepository.findByFullName(userDTO.getFullName()).isPresent()) {
			throw new IllegalArgumentException("A user with this name already exists.");
		}



		User user = new User();
		user.setFullName(userDTO.getFullName());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setCreatedDate(LocalDate.now());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		userRepository.save(user);
		return userDTO;

	}


	@Override
	public void delete(Long id) {
		User user = userRepository.findById(id).orElse(null);
		if (user != null){
			user.setRole("DELETED");
			userRepository.save(user);
		}
	}

	@Override
	public User update(Long id, User user) {
		return null;
	}

	@Override

	public User updateUser(Long id, UserDTO userDTO) {
		System.out.println("Okay----------------");
		User user = userRepository.findById(id).orElse(null);
		if (user != null){
			user.setFullName(userDTO.getFullName());

			user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
			user.setRole(userDTO.getRole());
			user.setEmail(userDTO.getEmail());

			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public List<User> allUsers() {
		return userRepository.findAll();
	}


	@Override
	public List<SearchDTO> findAll() {
		List<User> users = userRepository.findAll();
		List<SearchDTO> dtoList = new ArrayList<>();
		for (User user: users) {
			dtoList.add(new SearchDTO(user.getId(), user.getFullName(), user.getEmail()));
		}
		return dtoList;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email);
	}
}
