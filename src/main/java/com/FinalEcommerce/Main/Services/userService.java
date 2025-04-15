package com.FinalEcommerce.Main.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FinalEcommerce.Main.Entities.User;
import com.FinalEcommerce.Main.Repositories.userRepo;

@Service
public class userService {
	
	@Autowired
	userRepo obj;
	
	public User addUser(User user) {
		
		List<User> users = this.getAllUsers();
		
		if(users == null || users.isEmpty()) {
			return obj.save(user);
		}
		
		for(User x : users) {
			if(x.getUserName().trim().equals(user.getUserName().trim())) {
				return null;
			}
		}
		
		return obj.save(user);
	}
	
	public User getUserById(int id) {
		return obj.findById(id).orElse(null);
	}
	
	public void deleteUserById(int id) {
		obj.deleteById(id);
	}
	
	public User updateUser(User newUser) {
		return obj.save(newUser);
	}

	public List<User> getAllUsers() {
		return obj.findAll();
	}

	public User signInUser(String userName, String password) {
	    List<User> users = getAllUsers(); 

	    if (users == null || users.isEmpty()) {
	        System.out.println("User list is null or empty!");
	        return null;
	    }

	    System.out.println("Users in the database:");
	    for (User user : users) {
	        System.out.println("Username: [" + user.getUserName() + "], Password: [" + user.getPassword() + "]");
	    }

	    for (User user : users) {
	        if (user.getUserName().trim().equals(userName.trim()) &&
	            user.getPassword().trim().equals(password.trim())) {
	            System.out.println("User found: " + user);
	            return user;
	        }
	    }

	    System.out.println("No matching user found!");
	    return null;
	}


}
