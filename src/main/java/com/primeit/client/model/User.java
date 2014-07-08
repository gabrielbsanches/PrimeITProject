package com.primeit.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements java.io.Serializable {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;
	
	private String loginname;
	private String password;
	private String manager_name;
	private boolean enable;
	private String authority;
	private String email;
	private String phone;
	

	public User(){}
	public User (String loginName, String password, boolean enabled, String authority){
		this.loginname = loginName;
		this.password = password;
		this.enable = enabled;
		this.authority = authority;
	}
	
	@Column(name = "userid", unique = true, nullable = false)
	public long getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Column(name = "loginname")
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Column(name = "manager_name")
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	
	@Column(name = "enable")
	public boolean isEnabled() {
		return enable;
	}
	public void setEnabled(boolean enabled) {
		this.enable = enabled;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "authority")
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [loginName=" + loginname + 
				", password=" + password + 
				" manager_name="+ manager_name +
				" authority="+ authority +
				" email="+ email +
				" phone="+ phone +
				"]";
	}
	
	
	
}