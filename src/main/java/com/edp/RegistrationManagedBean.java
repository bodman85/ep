package com.edp;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edp.hbm.Role;
import com.edp.hbm.RoleName;
import com.edp.hbm.Status;
import com.edp.hbm.StatusName;
import com.edp.hbm.User;
import com.edp.util.HibernateUtil;

@ManagedBean(name = "regMBean")
@SessionScoped
public class RegistrationManagedBean {
	private String name;
	private char gender;
	private String login;
	private String password;
	private String confirmPassword;
	private String email;
	private String role;
	private String status;

	private static Logger log = Logger.getLogger(RegistrationManagedBean.class);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void register(ActionEvent actionEvent) throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		User user = new User();
		Role role = new Role(RoleName.CLIENT);
		Status status = new Status(StatusName.NEW);

		user.setName(this.getName());
		user.setGender(this.getGender());
		user.setLogin(this.getLogin());
		user.setPassword(this.getPassword());
		user.setEmail(this.getEmail());

		user.setRole(role);
		user.setStatus(status);

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			log.debug("New Record : " + user + ", wasCommitted : "
					+ tx.wasCommitted());
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				log.error(e.getMessage());
			}
		} finally {
			session.close();
		}
	}

	public List<User> getUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> userList = session.createCriteria(User.class).list();
		return userList;
	}
}
