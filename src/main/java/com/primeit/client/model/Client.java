package com.primeit.client.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "clients")
public class Client implements java.io.Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long client_id;
	
	private String client_code;
	private String client_company_name;
	private String client_name;
	private String client_comment;
	private Date last_date;
	private String email;
	private String phone;
 

	public Client() {
	}
 
	public Client(String clientCode, String clientName, String clientComment, Date lastDate) {
		this.client_code = clientCode;
		this.client_name = clientName;
		this.client_comment = clientComment;
		this.last_date = lastDate;
	}
 
	@Column(name = "client_id", unique = true, nullable = false)
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}


	@Column(name = "client_code")
	public String getClient_code() {
		return client_code;
	}
	public void setClient_code(String client_code) {
		this.client_code = client_code;
	}
	
	@Column(name = "client_company_name")
	public String getClient_company_name() {
		return client_company_name;
	}

	public void setClient_company_name(String client_company_name) {
		this.client_company_name = client_company_name;
	}
	
	@Column(name = "client_name")
	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	
	@Column(name = "client_comment")
	public String getClient_comment() {
		return client_comment;
	}

	public void setClient_comment(String client_comment) {
		this.client_comment = client_comment;
	}

	@Column(name = "last_date")
	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
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
		return "[client_id=" + client_id +
				", client_code=" + client_code +
				", client_company_name=" + client_company_name + 
				", client_name=" + client_name + 
				", client_comment=" + client_comment +
				", last_date=" + last_date +
				", email=" + email +
				", phone=" + phone +
				"]";
	}
}
