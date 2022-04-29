package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StateDemo {
	
	public static void main(String[] args) {
		System.out.println("hello com on.....");
		
		Configuration cfg= new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    
    	Employee employee = new Employee();
    	employee.setId(101);
    	employee.setName("ram");
    	employee.setCity("ktm");
    	employee.setCerti(new Certificate("java hiber", "2 month"));
    	
    	Session s= factory.openSession();
    	Transaction tx = s.beginTransaction();
    	
    	s.save(employee);
    	employee.setName("jhon");
    	tx.commit();
    	s.close();
    	factory.close();
    	
	}

}
