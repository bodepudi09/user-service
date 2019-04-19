package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;
import com.training.userservice.service.UserService;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RefreshScope
public class UserController {
	
	@Autowired
	 UserService userService;
	 
	 @RequestMapping(value = "/user/{id}", method =RequestMethod.GET )
	 public User getUserByID(@PathVariable("id") long id) {
	 return userService.findById(id);
	 }

	 @RequestMapping(value = "/userByName/{name}", method =RequestMethod.GET )
	 public List<User> getUserByName(@PathVariable("name") String name) {
	 return userService.findByName(name);
	 }
	 
	 @RequestMapping(value = "/userbylowername/{name}", method =RequestMethod.GET)
	 public List<User> getUserByNameLowercase(@PathVariable("name") String name) {
		 System.out.println(name);
	 return userService.findByLowerName(name);
	 }
	 
	 @RequestMapping(value = "/userbyaddress/{address}", method =RequestMethod.GET)
	 public List<User> getUserByAddress(@PathVariable("address") String address) {
	 return userService.findByLocation(address);
	 }
	 
	 @RequestMapping(value = "/userbynamecity", method =RequestMethod.GET)
	 public List<User> getUserByNameCity(@RequestParam(value="name",required=false) String name,@RequestParam(value="address",required=false) String address) {
	  return userService.getUserByNameCity(name, address);  
	 
	 }
	 
	 @RequestMapping(value = "/newUser", method = RequestMethod.POST)
     public ResponseEntity < String > createUser(@RequestBody User user) {        
         return userService.createUser(user);
     }
	 
	 @RequestMapping(value = "/user/{id}", method =RequestMethod.PUT)
	 public ResponseEntity<Object> updateUserByID(@RequestBody User user,@PathVariable("id") long id) {
	    return userService.updateUserByID(user,id);  
	  
	 }
	 
	 @RequestMapping(value = "/deleteUser/{id}", method =RequestMethod.PUT)
	 public ResponseEntity<Object> deleteUserByID(@PathVariable("id") long id) {
	    return userService.deleteUserByID(id);  
	  
	 }


}
