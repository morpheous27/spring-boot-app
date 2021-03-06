package org.nitin.restapp.controller;

import java.util.Map;

import org.nitin.restapp.dtos.User;
import org.nitin.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class RequestHandler {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User getData(@PathVariable long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/by-object/{id}")
	public User getDataByObject(@PathVariable long id) {
		User user = new User("dummy",99,id);
		return userService.getUserByObject(user);
	}
	
	@GetMapping("/all-cached-data")
	public Cache getAllCachedData() {
		return userService.getAllCachedData();
	}
	
	@GetMapping("/evict-and-show-cache/{id}")
	public Cache getUpdatedCacheAfterEviction(@PathVariable long id)
	{
		return userService.getAllCacheAfterEviction(id);
	}
	
	@GetMapping("/all-users")
	public Map<Long, User> getAllUsers()
	{
		return userService.getAllUsers();	
	}
	
}
