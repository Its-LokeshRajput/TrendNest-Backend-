package com.FinalEcommerce.Main.Controllers;

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

import com.FinalEcommerce.Main.Entities.Admin;
import com.FinalEcommerce.Main.Services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService obj;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin) {
		return ResponseEntity.ok(obj.addAdmin(admin));
	}
	
	@GetMapping("/getAdminById/{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(name = "adminId") int adminId) {
		return ResponseEntity.ok(obj.getAdminById(adminId));
	}
	
	@GetMapping("/getAllAdmins")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		return ResponseEntity.ok(obj.getAllAdmins());
	}
	
	@DeleteMapping("/deleteAdminById/{adminId}")
	public void deleteAdminById(@PathVariable(name = "adminId") int adminId) {
		obj.deleteAdminById(adminId);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin newAdmin) {
		
		Admin oldAdmin = obj.getAdminById(newAdmin.getAdminId());
		
		oldAdmin.setName(newAdmin.getName());
		oldAdmin.setEmail(newAdmin.getEmail());
		
		return ResponseEntity.ok(obj.addAdmin(oldAdmin));
	}
}
