package com.code.spotify.DAO;

import java.util.List;

import com.code.spotify.entity.Songs;



public interface SongsDAO {
	
	public int add(Songs songs);
	public int update(Songs songs);
	public int delete(Songs songs);
	public int delete(int id);
	//create some method to get the songs
	public List<Songs> getAll();
	public Songs getById(int id);
;


}
