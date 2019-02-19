package com.stefan.info.service;

import com.stefan.info.model.User;
import com.stefan.info.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User addNewUser(String name, String email, String username, String password) {
		
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setUsername(username);
		n.setPassword(password);
		
		userRepository.save(n);
		
		return n;
	}
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(int id) {
		
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent())
			throw new RuntimeException("id-ul "+  + id+  " nu exista");

		return user.get();
	}
	
	public void deleteById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new RuntimeException("user-ul cu id-ul "+  + id+  " nu exista");

		userRepository.deleteById(id);
	}

	public User save(User user){
		userRepository.save(user);
		return user;
	}


}
