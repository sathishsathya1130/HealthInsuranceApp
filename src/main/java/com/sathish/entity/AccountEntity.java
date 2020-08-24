package com.sathish.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Table(name = "ADMIN_TBL")
@Entity

/* @Where(clause="is_active=1") */
public class AccountEntity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "admin_seq_gen", sequenceName = "ADMIN_TBL_seq", allocationSize = 1)
	@GeneratedValue(generator = "admin_seq_gen ", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "ACCOUNT_STATUS")
	private String accStatus;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PWD")
	private String pwd;


	@Column(name = "GENDER")
	private String gender;

	@Column(name = "ROLE")
	private String role;

	@Column(name = "is_active")
	private Boolean active;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedDate;
}
