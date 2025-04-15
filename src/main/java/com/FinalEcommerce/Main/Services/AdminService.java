package com.FinalEcommerce.Main.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FinalEcommerce.Main.Entities.Admin;
import com.FinalEcommerce.Main.Repositories.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo obj;
	
	public Admin addAdmin(Admin admin) {
		return obj.save(admin);
	}
	
	public List<Admin> getAllAdmins() {
		return obj.findAll();
	}
	
	public Admin getAdminById(int id) {
		return obj.findById(id).orElse(null);
	}
	
	public void deleteAdminById(int id) {
		obj.deleteById(id);
	}
}
