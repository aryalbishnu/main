package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
    	System.out.println("start.....");
    	
    	//get ,  load
    	Configuration cfg= new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Session session = factory.openSession();
    	
    	//get- employee 105
    	Employee employee = (Employee)session.get(Employee.class, 105);
    	System.out.println(employee);
    	
    	//load employee 101
    	Employee employee1 = (Employee)session.load(Employee.class, 101);
    	System.out.println(employee1);
    	
    	session.close();
    	factory.close();
    }
}
