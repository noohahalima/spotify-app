package com.code.spotify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.spotify.entity.Artists;
@Service
public interface ArtistsService {

	public int add(Artists artists);
	public int update(Artists artists);
	public int delete(Artists artists);
	public int delete(int id);
	//create some method to get the songs
	public List<Artists> getAll();
	public Artists getById(int id);

}
