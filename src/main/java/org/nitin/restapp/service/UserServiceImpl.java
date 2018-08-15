package org.nitin.restapp.service;

import org.nitin.restapp.dao.UserDao;
import org.nitin.restapp.dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	CacheManager cacheManager;

	@Override
	@Cacheable("users")
	public User getUser(long id) {
		simulateSlowService();
		return userDao.getUser(id);
	}

	@Override
	@Cacheable("users")
	public User getUserByObject(User user) {
		simulateSlowService();
		return userDao.getUser(user.id);
	}
	
	/**
	 * Getting all cached values
	 */
	@Override
	public Cache getAllCachedData() {
		return cacheManager.getCache("users");
	}
	
	/**
	 * method to introduce slowness
	 */
	private void simulateSlowService() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
