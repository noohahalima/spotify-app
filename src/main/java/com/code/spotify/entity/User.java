package com.code.spotify.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



	
	@Entity
	@Table(name="userinfo")
	public class User {
		@Id
		@NotEmpty(message="required")
		@Email
		@NotEmpty(message="required")
		private String Email;
		/*
		 *^                             # start of line
	  (?=.*[0-9])                       # positive lookahead, digit [0-9]
	  (?=.*[a-z])                       # positive lookahead, one lowercase character [a-z]
	  (?=.*[A-Z])                       # positive lookahead, one uppercase character [A-Z]
	  (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the special character in this [..]
	  .                                 # matches anything
	  {8,20}                            # length at least 8 characters and maximum of 20 characters
	$                                   # end of line
		 */
		@Column(name="password")
		@NotNull(message = "reuiqred")
		@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message="Password should contains number uppercase and special chracater min 8 max 20") 
		//@Max(value=10,message="Maximum 10 character")
		private String pwd;
		
		@Column(name="name")
		@NotEmpty(message="required")
		private String name;
		
		
		public User()
		{
			
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}

		
		

