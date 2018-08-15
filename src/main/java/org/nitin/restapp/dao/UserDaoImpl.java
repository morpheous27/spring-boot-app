package org.nitin.restapp.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.nitin.restapp.dtos.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	Map<Long, User> userMap = new ConcurrentHashMap<>();
	
	@PostConstruct
	public void populateUserMap()
	{
		userMap.put(1l, new User("Nitin", 28, 1l));
		userMap.put(2l, new User("Nidhi", 26, 2l));
		userMap.put(3l, new User("Jatin", 24, 3l));
		userMap.put(4l, new User("Sharma", 24, 4l));
	}

	@Override
	public User getUser(long id) {
		return userMap.get(id);
	}

}
