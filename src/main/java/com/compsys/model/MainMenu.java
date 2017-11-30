package com.compsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mainmenu", schema = "public")
public class MainMenu  {

	private long id;
	private String name;
	private String adress;

	public MainMenu() {
	}

	public MainMenu(String name, String adress) {
		this.name = name;
		this.adress = adress;
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

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String adress) {
		this.adress = adress;
	}
	
	
	@Column(name = "adress", length = 30)
	public String getAdress() {
		return this.name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

}
