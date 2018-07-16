package com.facebook.dbutil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbHiberUtil {
	
	private static SessionFactory sessionFactory = null;
	private DbHiberUtil(){}
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory(){
		
		Configuration configure = new Configuration().configure();
		sessionFactory = configure.buildSessionFactory();
		if(sessionFactory == null){
			return sessionFactory;
		}
		return sessionFactory;
	}

}
