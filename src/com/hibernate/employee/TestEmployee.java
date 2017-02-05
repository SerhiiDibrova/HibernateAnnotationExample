package com.hibernate.employee;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class TestEmployee {
	
	public static void main(String[] args){
		
		//AnnotationConfiguration config = new AnnotationConfiguration();
	//	config.addAnnotatedClass(Employee.class);
	//	config.configure("hibernate.cfg.xml");
		
		
//	new SchemaExport(config).create(true, true);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		{
		Employee alex = new Employee();
	//	alex.setEmpId(100);
		alex.setEmpName("Sergiy Dibrova");
        alex.setEmpEmailAddress("Sergiyko@ukr.net");
        alex.setEmpPassword("vivipas");
        alex.setPermanent(true);
        alex.setEmpLoginDate(Date.valueOf("2010-06-05"));
        alex.setEmpJoinDate(new GregorianCalendar(2009,05,26));
        
		session.save(alex);
		}
		{
			Employee vova = new Employee();
			//	alex.setEmpId(100);
			vova.setEmpName("Vova Marchenko");
			vova.setEmpEmailAddress("vova@ukr.net");
			vova.setEmpPassword("Sfdrpas");
			vova.setPermanent(true);
			vova.setEmpLoginDate(new java.util.Date());
			vova.setEmpJoinDate(new GregorianCalendar(2007,07,06));
		        
				session.save(vova);
		}
		{
			Employee serhio = new Employee();
			//	alex.setEmpId(100);
			serhio.setEmpName("serhio serhio");
			serhio.setEmpEmailAddress("serhio@ukr.net");
			serhio.setEmpPassword("serhiodrpas");
			serhio.setPermanent(true);
			serhio.setEmpLoginDate(new java.util.Date());
			serhio.setEmpJoinDate(new GregorianCalendar(2001,01,16));
		        
				session.save(serhio);
		}
		session.getTransaction().commit();
	}

}
