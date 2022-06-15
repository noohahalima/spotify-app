package com.code.spotify.entity;

import java.util.Date;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
	@DateTimeFormat(pattern="yyyy-MM-dd" )
	private Date dobb;
	
	@OneToOne
	 @JoinColumn(name="songid")
	private Songs songs;
	
	public Songs getSongs() {
		return songs;
	}

	public void setSongs(Songs songs) {
		this.songs = songs;
	}
	
//	@ManyToMany
//	@JoinColumn(
//	  name = "songid"
//	)
//	private List<Songs> songs;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//		      cascade = {
//		          CascadeType.PERSIST,
//		          CascadeType.MERGE
//		      },
//		      mappedBy = "artists")
//		 
//		  private Set<Songs> songs = new HashSet<Songs>();

	

//	public Set<Songs> getSongs() {
//		return songs;
//	}
//
//	public void setSongs(Set<Songs> songs) {
//		this.songs = songs;
//	}

	public int getArtistid() {
		return artistid;
	}

	

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
