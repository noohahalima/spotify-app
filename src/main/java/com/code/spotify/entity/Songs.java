package com.code.spotify.entity;

import java.sql.Date;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.commons.CommonsMultipartFile;





@Entity
@Table(name="Songs")
public class Songs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="songid")
	private int songid;
	
	
	@Column(name="songname")
	@NotEmpty(message="required")
	private String songname;
	
	@Column(name="dor")
	@NotEmpty(message="required")
	@Size(min=1,message="required")
	@Pattern(regexp="^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$",message="Date should be in the format YYYY-MM-DD") 
	private String dor;
	
	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	private String filename;  
	
//	@ManyToMany
//	@JoinColumn(name = "artistid")
//	 List<Artists> artists;
	
	@OneToOne
	@JoinColumn(name="artistid")
	Artists artists;
	
	

	
//	public List<Artists> getArtists() {
//		return artists;
//	}
//
//	public void setArtists(List<Artists> artists) {
//		this.artists = artists;
//	}

	public int getSongid() {
		return songid;
	}

	public void setSongid(int songid) {
		this.songid = songid;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getDor() {
		return dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	

	

	public Artists getArtists() {
		return artists;
	}

	public void setArtists(Artists artists) {
		this.artists = artists;
	}

	public Songs() {
		
	}

	
	
	

}
