package com.stefan.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefan.info.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
