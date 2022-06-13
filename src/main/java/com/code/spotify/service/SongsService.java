package com.code.spotify.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.code.spotify.entity.Songs;
@Service
public interface SongsService {
	
	public int add(Songs songs);
	public int update(Songs songs);
	public int delete(Songs songs);
	public int delete(int id);
	//create some method to get the songs
	public List<Songs> getAll();
	public Songs getById(int id);

}
