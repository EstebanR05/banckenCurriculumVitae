package com.curriculum.vitae.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.vitae.user.entity.User;
import com.curriculum.vitae.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public static List<User> findAll(User user) {
		return UserController.findAll(user);
	}

	@PostMapping("/save")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) {
		User userUp = userService.getUserById(id);
		if (userUp == null) {
			return ResponseEntity.notFound().build();
		}

		userUp.setName(User.getName());
		userUp.setEmail(user.getEmail());
		userUp.setPassword(user.getPassword());
		userUp.setNeighbour(user.getNeighbour());
		userUp.setDob(user.getDob());

		userService.save(userUp);
		return ResponseEntity.ok(user);

	}

}
