package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.repository.UserRepository;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	Utils utils;
	@Autowired
	BCryptPasswordEncoder encoder;

	@Override
	public UserDto createUser(UserDto userDto) {

		if (userRepository.findUserByEmail(userDto.getEmail()).isPresent())
			throw new RuntimeException("Record already exist!");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		userEntity.setEncryptedPassword(encoder.encode(userDto.getPassword()));
		userEntity.setUserId(utils.generateUserId(30));

		UserEntity saved = userRepository.save(userEntity);

		UserDto responce = new UserDto();
		BeanUtils.copyProperties(saved, responce);

		return responce;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> userOpt = userRepository.findUserByEmail(email);
		if (!userOpt.isPresent()) throw new UsernameNotFoundException(email);
		UserEntity userEntity = userOpt.get();
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	}
}
