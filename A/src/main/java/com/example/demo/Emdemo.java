package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emdemo {
public static void main(String[] args) {
System.out.println("start.....");
	


	
	Employee employee1 = new Employee();
	Employee employee2 = new Employee();
	Configuration cfg= new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	employee1.setId(176);
	employee1.setName("hari");
	employee1.setCity("japan");
	
	Certificate certificate= new Certificate();
	certificate.setCourse("java");
	certificate.setDuration("1 month");
	
	employee2.setId(478);
	employee2.setName("shyam");
	employee2.setCity("tokyo");
	
	
	employee1.setCerti(certificate);
	
	Session s= factory.openSession();
	Transaction tx = s.beginTransaction();
	
	s.save(employee1);
	s.save(employee2);
	tx.commit();
	s.close();
	factory.close();
	
	

}	
}
