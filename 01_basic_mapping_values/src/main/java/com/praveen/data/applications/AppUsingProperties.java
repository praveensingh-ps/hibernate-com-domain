package com.praveen.data.applications;

import org.hibernate.Session;

import com.praveen.data.utilities.HibernateUtilProperties;

public class AppUsingProperties {

	public static void main(String[] args) {
		
		Session session = HibernateUtilProperties.getSessionFactory().openSession();
		session.beginTransaction();
		session.close();
	}
}
