package com.tju.manager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id ;
	private String username ;
	private String userpass ;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
	private Date regDatetime ;
	private String avatar;
	private String phone;
	private String email;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String username, String userpass, Date regDatetime, String avatar, String phone, String email) {
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.regDatetime = regDatetime;
		this.avatar = avatar;
		this.phone = phone;
		this.email = email;
	}
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public Date getRegDatetime() {
		return regDatetime;
	}
	public void setRegDatetime(Date regDatetime) {
		this.regDatetime = regDatetime;
	}

	public String getAvatar() { return avatar; }
	public void setAvatar(String avatar) { this.avatar = avatar; }

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", userpass=" + userpass + ", regDatetime=" + regDatetime
//				+ "]";
//	}
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", userpass='" + userpass + '\'' +
				", regDatetime=" + regDatetime +
				", avatar='" + avatar + '\'' +
				'}';
	}
}
