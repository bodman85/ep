package com.edp.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ep.kiev.ua
 * @since 21 Dec 2013
 * @version 1.0.0
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	/*	
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory getSessionFactory() throws HibernateException {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			
			configuration.setProperty("hibernate.connection.url",
					"jdbc:mysql://" + System.getenv("OPENSHIFT_MYSQL_DB_HOST")
							+ ":" + System.getenv("OPENSHIFT_MYSQL_DB_PORT")
							+ "/" + System.getenv("OPENSHIFT_APP_NAME"));
			
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
*/
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.setProperty(
					"hibernate.connection.url", "jdbc:mysql://"+
					System.getenv("OPENSHIFT_MYSQL_DB_HOST")+":"+
					System.getenv("OPENSHIFT_MYSQL_DB_PORT")+"/"+
					System.getenv("OPENSHIFT_APP_NAME"));
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		}

		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

}