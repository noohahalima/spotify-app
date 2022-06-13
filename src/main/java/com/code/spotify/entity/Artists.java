package com.code.spotify.entity;

import java.util.*;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Artists")
public class Artists {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="artistid")
	private int artistid;
	
	@Column(name="artistname")
	@NotEmpty(message="required")
	private String artistname;
	
	
	
	@Column(name="bio")
	@NotEmpty(message="required")
	private String bio;
	
	@Column(name="dobb")
	@NotEmpty(message="format yyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	private Date dobb;
	
//	@OneToOne
//	 @JoinColumn(name="Songs")
//	private Songs songs;
	
//	@ManyToMany
//	@JoinColumn(
//	  name = "songid"
//	)
//	private List<Songs> songs;
	
	

	

	public int getArtistid() {
		return artistid;
	}

//	public Songs getSongs() {
//		return songs;
//	}
//
//	public void setSongs(Songs songs) {
//		this.songs = songs;
//	}

	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}

//	public List<Songs> getSongs() {
//		return songs;
//	}
//
//	public void setSongs(List<Songs> songs) {
//		this.songs = songs;
//	}

	public Artists() {
		super();
	}

	

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}

	

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDobb() {
		return dobb;
	}

	public void setDobb(Date dobb) {
		this.dobb = dobb;
	}
	
	

}
