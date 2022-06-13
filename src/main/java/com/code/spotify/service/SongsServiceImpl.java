package com.code.spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.spotify.DAO.SongsDAO;
import com.code.spotify.entity.Songs;
@Service
@Transactional
public class SongsServiceImpl implements SongsService {
	@Autowired
	private SongsDAO songsdao;
	
	@Override
	@Transactional
	public int add(Songs songs) {
		// TODO Auto-generated method stub
		return songsdao.add(songs);
	}

	@Override
	public int update(Songs songs) {
		// TODO Auto-generated method stub
		return songsdao.update(songs);
	}

	@Override
	public int delete(Songs songs) {
		// TODO Auto-generated method stub
		return songsdao.delete(songs);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return songsdao.delete(id);
	}

	@Override
	public List<Songs> getAll() {
		// TODO Auto-generated method stub
		return songsdao.getAll();
	}

	@Override
	public Songs getById(int id) {
		// TODO Auto-generated method stub
		return songsdao.getById(id);
	}

}
