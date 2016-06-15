package com.sample.ws.mdl;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue
	private int userId;

	@Column(name = "name", nullable = false)
	private String name;

	@OneToMany
	@JoinTable(name = "user_role_map", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "userId") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "roleId", unique = true) })
	private Set<UserRole> roles = new HashSet<UserRole>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time", nullable = false)
	private Date rowCreateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated")
	private Date rowLastUpdateTime;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public Date getRowCreateTime() {
		return rowCreateTime;
	}

	public Date getRowLastUpdateTime() {
		return rowLastUpdateTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public void setRowCreateTime(Date rowCreateTime) {
		this.rowCreateTime = rowCreateTime;
	}

	public void setRowLastUpdateTime(Date rowLastUpdateTime) {
		this.rowLastUpdateTime = rowLastUpdateTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", roles=" + roles + ", rowCreateTime=" + rowCreateTime
				+ ", rowLastUpdateTime=" + rowLastUpdateTime + "]";
	}

}
