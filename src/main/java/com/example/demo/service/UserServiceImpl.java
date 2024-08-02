package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.dto.UserDto;
import com.example.demo.repositories.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		String role = userDto.getRole() != null ? userDto.getRole() : "USER";
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), role,
				userDto.getFullname());
		return userRepository.save(user);
	}

}