package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLexample {
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
    		 System.out.println(employee.getName()+" : " +employee.getCerti().getCourse());
    	
    	 }
    	 //deleting of query use
    	 System.out.println("-------------------");
    	 
    	 Transaction tx=s.beginTransaction();
    //	Query q1= s.createQuery("delete from Employee s where s.city='tokyo'");
    	
    //	 int r=q1.executeUpdate();
    	// System.out.println("Deleted:");
    //	 System.out.println(q1);
    	 
    	 
    	 //Update 
    	 
    	Query q2= s.createQuery("update Employee set city=:c  where name=:n");
    	 q2.setParameter("c", "pokhara");
    	 q2.setParameter("n", "nepal");
    	 int r= q2.executeUpdate();
    	 System.out.println(r + "objects updated");
    	 tx.commit();
    	
    	s.close();
    	factory.close();
    	 
}
}
