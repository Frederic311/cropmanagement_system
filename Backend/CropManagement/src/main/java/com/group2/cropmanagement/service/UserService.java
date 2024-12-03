package com.group2.cropmanagement.service;
//import group1.iusjcrm.user_management_service.dto.LoginDTO;
import com.group2.cropmanagement.dto.SearchDTO;
import com.group2.cropmanagement.dto.UserDTO;
import com.group2.cropmanagement.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
	UserDTO saveUser(UserDTO dto);

	User updateUser(Long id, UserDTO userDTO);

	List<User> allUsers();


	//String login(LoginDTO dto);

	void delete(Long id);



	User update(Long id, User user);

	List<SearchDTO> findAll();


	User findById(Long id);

	User findByEmail(String email);

	String generateToken(String email);

	void validateToken(String token, UserDetails userDetails);


	User getUserFromToken(String token);
}
