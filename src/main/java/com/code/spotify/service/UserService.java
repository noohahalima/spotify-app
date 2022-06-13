package com.code.spotify.service;

import java.util.List;

import com.code.spotify.entity.User;



public interface UserService {
	public String add(User user);
	public String update(User user);
	public int delete(User user);
	public int delete(String id);
	//create some method to get the student
	public List<User> getAll();
	public User getById(String id);
	public User authenticateUser(String emailid,String password);
}
