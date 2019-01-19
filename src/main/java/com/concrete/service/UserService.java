package com.concrete.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concrete.data.UserRepository;
import com.concrete.exception.DuplicateUserException;
import com.concrete.exception.InvalidPasswordException;
import com.concrete.exception.InvalidSessionException;
import com.concrete.exception.NotAuthorizedException;
import com.concrete.exception.UserDoesNotExistException;
import com.concrete.helper.JwtTokenUtil;
import com.concrete.helper.PasswordUtil;
import com.concrete.model.LoginTO;
import com.concrete.model.TypeProfileEnum;
import com.concrete.model.User;
import com.concrete.model.UserTO;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PhoneService phoneService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Transactional
	public User register(UserTO userto) {

		verifyDuplicateUser(userto);

		User user = new User();
		user.setName(userto.getName());
		user.setEmail(userto.getEmail());
		user.setPassword(PasswordUtil.generateBCrypt(userto.getPassword()));
		user.setCreated(LocalDateTime.now());
		user.setPhone(phoneService.saveList(userto.getPhones()));
		user.setTypeProfileEnum(TypeProfileEnum.ROLE_ADMIN);

		user.setToken(jwtTokenUtil.obterToken(userto));

		User userCreated = userRepository.save(user);
		return userCreated;
	}
	
	public User returnUser(int id, String token) {
		Optional<User> optionalUser = userRepository.findById((long) id);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			if (user.getToken().equals(token)) {
				if (verifyInvalidLastLogin(user)) {
					throw new InvalidSessionException();
				}
			} else {
				throw new NotAuthorizedException();
			}
		} else {
			throw new UserDoesNotExistException();
		}

		return optionalUser.get();
	}
	
	private boolean verifyInvalidLastLogin(User user) {
		Long lastLogin = user.getLast_login().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Long timeSinceLastLogin = System.currentTimeMillis() - lastLogin;

		return timeSinceLastLogin >= 1800000;
	}
	
	@Transactional
	public User login(LoginTO loginTO) {
		User user = userRepository.findByEmail(loginTO.getEmail());

		if (user == null) {
			throw new UserDoesNotExistException();
		}

		if (!PasswordUtil.validPassword(loginTO.getPassword(), user.getPassword())) {
			throw new InvalidPasswordException();
		}

		user.setLast_login(LocalDateTime.now());
		user.setModified(LocalDateTime.now());
		userRepository.save(user);

		return user;

	}

	private void verifyDuplicateUser(UserTO userTO) {
		User user = userRepository.findByEmail(userTO.getEmail());

		if (user != null) {
			throw new DuplicateUserException();
		}
	}
}
