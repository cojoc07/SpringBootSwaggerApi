package com.stefan.info.controller;

import com.stefan.info.controller.dto.UserRequestRepresentation;
import com.stefan.info.controller.dto.UserResponseRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stefan.info.model.User;
import com.stefan.info.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController    
@RequestMapping(path="/users") 
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(path="/add")
	public UserResponseRepresentation addNewUser (@RequestParam String name, @RequestParam String email,
			@RequestParam String username, @RequestParam String password) {

		User user = userService.addNewUser(name, email, username, password);
		return UserResponseRepresentation.convert(user);
	}

	@GetMapping(path="/all")
	public List<UserResponseRepresentation> getAllUsers() {
		return userService.findAll()
				.stream()
				.map(UserResponseRepresentation::convert)
				.collect(Collectors.toList());
	}
	
	@GetMapping(path="/all/{userId}")
	public UserResponseRepresentation getUserById(@PathVariable int userId) {
		return UserResponseRepresentation.convert(userService.findById(userId));
	}

	@PutMapping(path="all/{userId}")
	public UserResponseRepresentation update(@PathVariable int userId, @RequestBody User user) {
		User nou = userService.findById(userId);

		nou.setName(user.getName());
		nou.setEmail(user.getEmail());
		nou.setUsername(user.getUsername());
		nou.setPassword(user.getPassword());

		return UserResponseRepresentation.convert(userService.save(nou));
	}

	@PostMapping(path="all/addPost")
	public UserResponseRepresentation postCreate(@RequestBody UserRequestRepresentation user) {
		User nou = new User();

		nou.setName(user.getName());
		nou.setEmail(user.getEmail());
		nou.setUsername(user.getUsername());
		nou.setPassword(user.getPassword());

		return UserResponseRepresentation.convert(userService.save(nou));
	}
	
	@DeleteMapping(path="/all/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userService.deleteById(userId);
	}

}