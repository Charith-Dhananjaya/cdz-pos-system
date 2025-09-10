package com.cdz.repository;

import com.cdz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


    User findByEmail(String username);


}
