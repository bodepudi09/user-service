package com.training.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.userservice.model.User;
import com.training.userservice.repository.UserCRUDRepository;

@Service("UserService")
	public class UserServiceImpl implements UserService{

//	 @Autowired
//	 UserRepository userRepository;
	
	@Autowired
	UserCRUDRepository userCRUDRepository;
	 
	
	 @Override
	 public User findById(Long id) {
	  
	//  return userRepository.findByID(id);
	  return userCRUDRepository.findById(id).get();

	 }

	public List<User> findByName(String name) {
		return userCRUDRepository.findByNameIgnoreCase(name);
	}

	@Override
	public List<User> findByLowerName(String name) {
		return userCRUDRepository.findByLowerName(name);
	}

	@Override
	public List<User> findByLocation(String address) {
		return userCRUDRepository.findByLocation(address);
	}


	public List<User> getUserByNameCity(String name, String address) {
		System.out.println(name + " jjj:" + address);
		return userCRUDRepository.findUsersByCityAndName(address, name);
		}

	@Override
	public ResponseEntity<String> createUser(User user) {
		User savedUser = userCRUDRepository.save(user);
		if(savedUser != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build(); 
	}

	@Override
	public ResponseEntity<Object> updateUserByID(User user, long id) {
		Optional<User> user1 = userCRUDRepository.findById(id);
		
		if(user1.isPresent()) {
			user.setId(id);
			userCRUDRepository.save(user);
			return ResponseEntity.noContent().build();  

			
		} else {
			return ResponseEntity.notFound().build();

		}
		}

	@Override
	public ResponseEntity<Object> deleteUserByID(long id) {
		Optional<User> user = userCRUDRepository.findById(id);
		if(user.isPresent()) {
			userCRUDRepository.delete(user.get());
			return ResponseEntity.noContent().build();  
		}
		return ResponseEntity.notFound().build();	}
}


