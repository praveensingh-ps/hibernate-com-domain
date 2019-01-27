package com.praveen.data.applications;

import java.util.Date;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.praveen.data.entities.AccountType;

public class App {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		
		/* Configuration */
		Configuration configuration = new Configuration();

		/** Register the mapping metadata with the configuration. Since the metadata is
         *  contained on a class and we are performing via annotations we have to register
		 *	the AccountType with our configuration.
		*/
		 configuration.addAnnotatedClass(AccountType.class);

		configuration.setProperties(new Properties() {
			{
				put("hibernate.connection.username", "root");
				put("hibernate.connection.password", "root");
				put("hibernate.connection.driver_class",
						"com.mysql.cj.jdbc.Driver");
				put("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/hibernate-db-2");
				put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
				put("hibernate.hbm2ddl.auto","update");
			}
		});

		/** Building SessionFactory */
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(new StandardServiceRegistryBuilder(
						).applySettings(configuration.getProperties()).build());
	
		/** Obtain Session and Call Persistence Methods */
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		AccountType type = new AccountType();

		type.setName("Checking");
		type.setCreatedDate(new Date());
		type.setLastUpdatedDate(new Date());
		type.setCreatedBy("kevinbowersox");
		type.setLastUpdatedBy("kevinbowersox");
		
		session.save(type);
		session.getTransaction().commit();
		session.close();
	}
}
