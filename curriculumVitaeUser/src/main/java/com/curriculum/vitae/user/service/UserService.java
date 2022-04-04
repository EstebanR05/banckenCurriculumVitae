package com.curriculum.vitae.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.vitae.user.entity.User;
import com.curriculum.vitae.user.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public java.util.List<User> getAll() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public User save(User user) {
		User UserNew= userRepository.save(user);
		return UserNew;
	} 
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
}
