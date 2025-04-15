package com.FinalEcommerce.Main.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
