package com.FinalEcommerce.Main.Controllers;

import java.util.Iterator;
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

import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Services.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	userService obj;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		return ResponseEntity.ok(obj.addUser(user));
	}
	
	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "userId") int userId) {
		return ResponseEntity.ok(obj.getUserById(userId));
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(obj.getAllUsers());
	}
	
	@DeleteMapping("/deleteUserById/{userId}")
	public void deleteUserById(@PathVariable(name = "userId") int userId) {
		obj.deleteUserById(userId);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User newUser) {
		return ResponseEntity.ok(obj.updateUser(newUser));
	}
	
	@GetMapping("/{userName}/{password}")
	public ResponseEntity<User> signInUser(@PathVariable(name = "userName") String userName, @PathVariable(name = "password") String password) {
		return ResponseEntity.ok(obj.signInUser(userName,password));
	}
}
