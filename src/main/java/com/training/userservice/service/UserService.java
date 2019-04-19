package com.training.userservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.userservice.model.User;

public interface UserService {

User findById(Long id);

List<User> findByName(String name);

public List<User> findByLowerName(String name);

public List<User> findByLocation(String address);

List<User> getUserByNameCity(String name, String address);

ResponseEntity<String> createUser(User user);

ResponseEntity<Object> updateUserByID(User user, long id);

ResponseEntity<Object> deleteUserByID(long id);

}
