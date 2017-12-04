package com.compsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User {

	private long id;
	private RightsGroup rightsGroup;
	private String firstname;
	private String lastname;
	private String nickname;
	private String password;
	private Boolean isactive;

	public User() {
	}

	public User(String firstname, String lastname, String nickname) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
	}

	public User(String firstname, String lastname, String nickname, Boolean isactive, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nickname = nickname;
		this.isactive = isactive;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rightsgroup_id")
	public RightsGroup getRightsGroup() {
		return this.rightsGroup;
	}

	public void setRightsGroup(RightsGroup rightsGroup) {
		this.rightsGroup = rightsGroup;
	}

	@Column(name = "firstname", nullable = false, length = 40)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 40)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "nickname", nullable = false, length = 40)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "isactive")
	public Boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
