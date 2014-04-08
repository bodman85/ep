package com.edp;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginMBean")
@SessionScoped
public class LoginManagedBean {

	private String username;

	private String password;

	private boolean loggedIn = false;

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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void login(ActionEvent actionEvent) throws IOException {
		FacesMessage fmsg = null;
		ResourceBundle msg = ResourceBundle.getBundle("messages", FacesContext
				.getCurrentInstance().getViewRoot().getLocale());
		RequestContext context = RequestContext.getCurrentInstance();

		if (username != null && username.equals("admin") && password != null
				&& password.equals("admin")) {
			loggedIn = true;
			fmsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					msg.getString("welcome"), username);
			FacesContext.getCurrentInstance().addMessage(null, fmsg);
			context.update("growlForm:growl");
		} else {
			loggedIn = false;
			fmsg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					msg.getString("loginError"), msg.getString("wrongUserPass"));
			FacesContext.getCurrentInstance().addMessage(null, fmsg);
			context.update("growlForm:growl");
		}
		context.addCallbackParam("loggedIn", loggedIn);
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		loggedIn = false;
		return "/pages/index.xhtml?faces-redirect=true";
	}

	public void cancel(ActionEvent actionEvent) throws IOException{
		//immediate="true" on cancel button will skip validation
		this.username = "";// clear cached values
		this.password = "";// form inputs will be empty when dialog opens second
							// time
	}
}
