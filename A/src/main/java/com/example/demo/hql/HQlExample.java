package com.example.demo.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.Employee;


public class HQlExample {
	
	public static void main(String[] args) {
		System.out.println("hello com on.....");
		

		Configuration cfg= new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	SessionFactory factory = cfg.buildSessionFactory();
    	
    	Session s= factory.openSession();
    	
    	String query ="from Employee";
    	 Query q = s.createQuery(query);
    	
    	 List<Employee>list=q.list();
    	 
    	 for(Employee employee:list)
    	 {
    		 System.out.println(employee.getName());
    	 }
    	
    	s.close();
    	factory.close();

}
}
