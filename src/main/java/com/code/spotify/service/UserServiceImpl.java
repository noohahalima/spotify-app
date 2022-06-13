package com.code.spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.spotify.DAO.UserDAO;
import com.code.spotify.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
UserDAO userDAO;
	@Override
	@Transactional
	public String add(User user) {
		// TODO Auto-generated method stub
		return userDAO.add(user);
	}

	@Override
	@Transactional
	public String update(User user) {
		// TODO Auto-generated method stub
		return userDAO.update(user);
	}

	@Override
	@Transactional
	public int delete(User user) {
		// TODO Auto-generated method stub
		return userDAO.delete(user);
	}

	@Override
	@Transactional
	public int delete(String id) {
		// TODO Auto-generated method stub
	return userDAO.delete(id);
	}

	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return  userDAO.getAll();
	}

	@Override
	@Transactional
	public User getById(String id) {
		// TODO Auto-generated method stub
		 return userDAO.getById(id);
	}

	@Override
	public User authenticateUser(String emailid, String password) {
		// TODO Auto-generated method stub
		return userDAO.authenticateUser(emailid, password);
	}

}
