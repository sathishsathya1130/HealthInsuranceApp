package com.sathish.model;

import java.util.Date;

import lombok.Data;

@Data
public class Account {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String role;
	private String pwd;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;
	
	
	

}
