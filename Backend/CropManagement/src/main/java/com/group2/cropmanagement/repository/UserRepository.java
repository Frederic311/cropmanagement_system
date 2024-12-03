package com.group2.cropmanagement.repository;

import com.group2.cropmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail (String email);

	Optional<User> findByFullName(String fullName);

}
