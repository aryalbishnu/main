package com.example.demo.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
	SessionFactory factory	=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
   
	Person p= new Person(12, "ram", "heloo", "djdk");
	Session session= factory.openSession();
	Transaction tx = session.beginTransaction();
	session.save(p);
	
	tx.commit();
	session.close();

	factory.close();
	}

}
