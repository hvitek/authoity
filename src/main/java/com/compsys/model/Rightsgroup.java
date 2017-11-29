package com.compsys.model;

// default package
// Generated 17.10.2017 15:06:49 by Hibernate Tools 5.2.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Rightsgroup generated by hbm2java
 */
@Entity
@Table(name = "rightsgroup", schema = "public")
public class Rightsgroup  {

	private int id;
	private String name;
	protected Integer[] rights;

	public Rightsgroup() {
	}

	public Rightsgroup(int id) {
		this.id = id;
	}

	public Rightsgroup(String name, Integer[] rights) {
		this.id = id;
		this.name = name;
		this.rights = rights;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "rights")
	public Integer[] getRights() {
		return this.rights;
	}
	
	

	public void setRights(Integer[] rightsId) {
		this.rights = rightsId;
	}

	
	
	
	@Transient
	public String getRightsAsString() {
		return Arrays.toString(rights);
	}

}