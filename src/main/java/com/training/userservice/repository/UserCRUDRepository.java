package com.training.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.training.userservice.model.User;
import com.training.userservice.repository.UserCRUDRepositoryCustom;


public interface UserCRUDRepository extends JpaRepository<User, Long> , UserCRUDRepositoryCustom{

	List<User> findByNameIgnoreCase(String name);
	
	//List<User> findByLowerName(String name);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.address) = LOWER(:address)")
    public List<User> findByLocation(@Param("address") String address);

}
