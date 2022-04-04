package com.curriculum.vitae.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.vitae.user.entity.User;
import com.curriculum.vitae.user.service.UserService;

import antlr.StringUtils;
import ch.qos.logback.core.util.StringCollectionUtil;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public static List<User> findAll(User user){
		return UserController.findAll(user);
	}
	
/*	@GetMapping("/save")
	public User save(@RequestBody User user) {
		if (isBlank(User.getName())) {
			System.out.println("el nombre falta");
		}
		return userService.save(user);
	}*/
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
	
}
