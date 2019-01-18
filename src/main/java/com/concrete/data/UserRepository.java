package com.concrete.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concrete.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
