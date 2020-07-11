package com.rimsoft.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class User {
	 @Id @GeneratedValue(strategy=GenerationType.AUTO) int id;
	 
	 private String name;
	 
	 private String password;
	 
	 private String tel;
	 
	 private boolean is2fa;
	 
	 
	 	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String password, boolean is2fa,String tel) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.is2fa = is2fa;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIs2fa() {
		return is2fa;
	}

	public void setIs2fa(boolean is2fa) {
		this.is2fa = is2fa;
	}

	public String getTel() {
		// TODO Auto-generated method stub
		return this.tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	 
}