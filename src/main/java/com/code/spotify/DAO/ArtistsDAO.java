package com.code.spotify.DAO;

import java.util.List;

import com.code.spotify.entity.Artists;
import com.code.spotify.entity.Songs;

public interface ArtistsDAO {


	
	public int add(Artists artists);
	public int update(Artists artists);
	public int delete(Artists artists);
	public int delete(int id);
	//create some method to get the songs
	public List<Artists> getAll();
	public Artists getById(int id);

};
