package com.jsp.SpringPro.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringPro.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
