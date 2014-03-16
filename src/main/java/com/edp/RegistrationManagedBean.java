package com.edp;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "regMBean")
@SessionScoped
public class RegistrationManagedBean {
	private String name;
	private char sex;
	private String username;
	private String password;
	private String confirmPassword;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public char getSex() {
		return sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void register(ActionEvent actionEvent) throws IOException {
		FacesMessage fmsg = null;
		ResourceBundle msg = ResourceBundle.getBundle("messages", FacesContext
				.getCurrentInstance().getViewRoot().getLocale());
		RequestContext context = RequestContext.getCurrentInstance();

	}
}
