package com.training.userservice.repository;

import java.util.List;

import com.training.userservice.model.User;

public interface UserCRUDRepositoryCustom {
	
	List<User> findUsersByCityAndName(String city, String name);

}
