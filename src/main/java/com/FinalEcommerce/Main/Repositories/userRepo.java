package com.FinalEcommerce.Main.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FinalEcommerce.Main.Entities.User;

@Repository
public interface userRepo extends JpaRepository<User, Integer>{

}
