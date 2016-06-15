package com.sample.ws.dao;

import java.util.List;

import com.sample.ws.mdl.User;

public interface UserDAO {

	void save(User u);

	List<User> list();

}