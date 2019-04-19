package com.training.userservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.training.userservice.model.User;

@Repository
public class UserRepository {

	@Autowired 
	 JdbcTemplate jdbcTemplate;  
	 
	 public User findByID(Long id) {
	  
	  return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] { id },
	    new BeanPropertyRowMapper<User>(User.class));
	  
	 }

}
