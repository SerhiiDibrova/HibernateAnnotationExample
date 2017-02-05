package com.hibernate.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class TestCustomer {

	
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Customer.class);
		config.configure("hibernate.cfg.xml");
		
		
	new SchemaExport(config).create(true, true);
	
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	session.beginTransaction();
	
	
	
	Customer vivi = new Customer();
	vivi.setCustomerName("vivi");
	vivi.setCustomerAddress("12 bazana str");
	vivi.setCreditScore(780);
	vivi.setRewardPoints(12051);
	
	session.save(vivi);
	
	session.getTransaction().commit();
		

	}

}
