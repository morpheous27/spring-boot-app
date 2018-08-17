package org.nitin.restapp.dao;

import java.util.Map;

import org.nitin.restapp.dtos.User;

public interface UserDao {

	public User getUser(long id);

	public Map<Long, User> getAllUsers();

}
