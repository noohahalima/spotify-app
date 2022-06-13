package com.code.spotify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code.spotify.DAO.ArtistsDAO;
import com.code.spotify.DAO.SongsDAO;
import com.code.spotify.entity.Artists;
@Service
@Transactional
public class ArtistsServiceImpl implements ArtistsService{
	@Autowired
	private ArtistsDAO artistsDAO;
	
	@Override
	@Transactional
	public int add(Artists artists) {
		// TODO Auto-generated method stub
		return artistsDAO.add(artists);
	}

	@Override
	public int update(Artists artists) {
		// TODO Auto-generated method stub
		return artistsDAO.update(artists);
	}

	@Override
	public int delete(Artists artists) {
		// TODO Auto-generated method stub
		return artistsDAO.delete(artists);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return artistsDAO.delete(id);
	}

	@Override
	public List<Artists> getAll() {
		// TODO Auto-generated method stub
		return artistsDAO.getAll();
	}

	@Override
	public Artists getById(int id) {
		// TODO Auto-generated method stub
		return artistsDAO.getById(id);
	}

}
