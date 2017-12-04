package com.compsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendanceaction", schema = "public")
public class AttendanceAction {

	//rows_determiner
	private long id;
	private String name;
	private Boolean isincoming;
	private Boolean isoutcoming;
	//rows_determiner
	
	public AttendanceAction() {
	}

	public AttendanceAction(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public AttendanceAction(String name,  Boolean isincoming, Boolean isoutcoming) {
		this.name = name;
		this.isincoming = isincoming;
		this.isoutcoming = isoutcoming;
	}
	
	public AttendanceAction(long id, String name, Boolean isincoming, Boolean isoutcoming) {
		this.id = id;
		this.name = name;
		this.isincoming = isincoming;
		this.isoutcoming = isoutcoming;
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

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isincoming")
	public Boolean getIsincoming() {
		return this.isincoming;
	}

	public void setIsincoming(Boolean isincoming) {
		this.isincoming = isincoming;
	}

	@Column(name = "isoutcoming")
	public Boolean getIsoutcoming() {
		return this.isoutcoming;
	}

	public void setIsoutcoming(Boolean isoutcoming) {
		this.isoutcoming = isoutcoming;
	}

}