package com.example.demo.sap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytoMany {
	public static void main(String[] args) {
	
System.out.println("start.....");
	
	Configuration cfg= new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
    Emp e1= new Emp();
    Emp e2= new Emp();
    
    e1.setEid(10);
    e1.setName("ram");
    
    e2.setEid(11);
    e2.setName("shyam");
    
    
    Project p1= new Project();
    Project p2= new Project();
    
    p1.setPid(5);
    p1.setProjecname("Management");
    
    p2.setPid(6);
    p2.setProjecname("It");
	
    
    List<Emp>list1= new ArrayList<Emp>();
    List<Project>list2= new ArrayList<Project>();
    
    list1.add(e1);
    list1.add(e2);
    
    list2.add(p1);
    list2.add(p2);
    
    e1.setProjects(list2);
    
    p2.setEmps(list1);
    
    Session s= factory.openSession();
    Transaction tx= s.beginTransaction();
	
	s.save(e1);
	s.save(e2);
	s.save(p1);
	s.save(p2);
	
	tx.commit();
	s.close();
	factory.close();
}
}
