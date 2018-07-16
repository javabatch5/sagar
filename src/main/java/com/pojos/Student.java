package com.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Student1")
public class Student {
	private String name;
	@Id
	private String uname;
	private String pwrd;
	private String mnumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwrd() {
		return pwrd;
	}
	public void setPwrd(String pwrd) {
		this.pwrd = pwrd;
	}
	public String getMnumber() {
		return mnumber;
	}
	public void setMnumber(String mnumber) {
		this.mnumber = mnumber;
	}

	

}
