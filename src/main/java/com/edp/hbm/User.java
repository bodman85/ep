package com.edp.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author onlinetechvision.com
 * @since 3 Oct 2011
 * @version 1.0.0
 * 
 */

@Entity
@Table(name = "USER")
public class User {

	private int id;
	private String name;
	private char gender;
	private String login;
	private String password;
	private String email;
	private Role role;
	private Status status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "GENDER")
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Column(name = "LOGIN")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne
	@JoinColumn(name = "ROLE")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToOne
	@JoinColumn(name = "STATUS")
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(id);
		strBuff.append(", name : ").append(name);
		strBuff.append(", gender : ").append(gender);
		strBuff.append(", login : ").append(login);
		strBuff.append(", password : ").append(password);
		strBuff.append(", email : ").append(email);
		strBuff.append(", role : ").append(role);
		strBuff.append(", status : ").append(status);
		return strBuff.toString();
	}
	
	@Override
	public int hashCode() {
	    return id;
	}

	@Override
	public boolean equals(final Object obj) {
	    if (obj instanceof User) {
	        User item = (User) obj;
	        return item.getId()==getId();
	    }
	    return false;
	}
}
