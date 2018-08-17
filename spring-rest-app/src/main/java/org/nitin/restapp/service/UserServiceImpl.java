package org.nitin.restapp.service;

import java.util.Map;

import org.nitin.restapp.dao.UserDao;
import org.nitin.restapp.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CacheManager cacheManager;

	/**
	 * Return the user from the cache or service for the first time and 
	 * then cache the object against id.
	 */
	@Override
	@Cacheable("users")
	public User getUser(long id) {
		Utility.simulateSlowService();
		return userDao.getUser(id);
	}

	/**
	 * Method to get the user by user object and cache the object with complete 
	 * user argument as key. Note that to avoid duplicate keys, hashcode and equals 
	 * should be implemented by the key.
	 */
	@Override
	@Cacheable("users")
	public User getUserByObject(User user) {
		Utility.simulateSlowService();
		return userDao.getUser(user.id);
	}
	
	/**
	 * Getting all cached values from cache.
	 */
	@Override
	public Cache getAllCachedData() {
		return cacheManager.getCache("users");
	}
	
	/**
	 * Use this method to evict a cached item using the id.
	 */
	@Override
	@CacheEvict(value = "users",key= "#id")
	public Cache getAllCacheAfterEviction(long id) {
		return cacheManager.getCache("users");
	}
	
	/**
	 * This will return all users map and get them against a simpleKey(autoGenerated).
	 */
	@Override
	@Cacheable("users")
	public Map<Long, User> getAllUsers() {
		return userDao.getAllUsers();
	}

}