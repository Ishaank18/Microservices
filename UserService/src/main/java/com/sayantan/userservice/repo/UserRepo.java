package com.sayantan.userservice.repo;

import org.springframework.stereotype.Repository;

import com.sayantan.userservice.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User, String>{

}
