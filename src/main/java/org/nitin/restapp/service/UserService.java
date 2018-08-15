package org.nitin.restapp.service;

import org.nitin.restapp.dtos.User;
import org.springframework.cache.Cache;

public interface UserService {

	public User getUser(long id);

	public Cache getAllCachedData();

	User getUserByObject(User user);
}
