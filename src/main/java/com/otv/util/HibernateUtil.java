package com.otv.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ep.kiev.ua
 * @since 21 Dec 2013
 * @version 1.0.0
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.setProperty(
					"hibernate.connection.url", "jdbc:"+
					System.getenv("OPENSHIFT_MYSQL_DB_URL")
							+ System.getenv("OPENSHIFT_APP_NAME"));
			sessionFactory = cfg.buildSessionFactory();
		}

		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

}