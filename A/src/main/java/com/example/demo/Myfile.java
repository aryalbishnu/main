package com.example.demo;

import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Myfile {
public static void main(String[] args)throws IOException{
	
	System.out.println("start.....");
	
	Configuration cfg= new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory = cfg.buildSessionFactory();
	
	//creating employee
	Employee st = new Employee();
	  st.setId(1012);
	  st.setName("ramri");
	  st.setCity("chiba");
	System.out.println(st);
	
	//creatinf address object
	Address ad= new Address();
	ad.setStreet("street1");
	ad.setCity("nepal");
	ad.setOpen(true);
	ad.setAddDate(new Date());
	ad.setX(9.5);
	
	//reading image
	//FileInputStream fis = new FileInputStream("src/main/java/png.jpg");
	//byte[] data = new byte[fis.available()];
	//fis.read(data);
	//ad.setImage(data);
	
	Session session= factory.openSession();
	
	Transaction tx =session.beginTransaction();
	session.save(st);
	session.save(ad);
	tx.commit();
	session.close();
	System.out.println("Done......");
	
}
}
