package org.wjlmgqs.entity;

import java.util.Date;

public class User {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", status=" + status + ", email=" + email
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}
	private String name = null;
	private String status = null;
	private String email = null;
	private Date lastLoginTime = null;
	
}
