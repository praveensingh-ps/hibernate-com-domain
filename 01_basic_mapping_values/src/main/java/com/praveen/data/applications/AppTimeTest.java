package com.praveen.data.applications;

import com.praveen.data.entities.TimeTest;
import com.praveen.data.utilities.HibernateUtil;

import java.util.Date;
import org.hibernate.Session;

public class AppTimeTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			TimeTest test = new TimeTest(new Date());
			session.save(test);
			session.getTransaction().commit();
			
			session.refresh(test);
			
			System.out.println(test.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
	}
}
