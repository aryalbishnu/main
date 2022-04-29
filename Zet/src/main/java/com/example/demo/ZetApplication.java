package com.example.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZetApplication.class, args);
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		//System.out.println(factory);
		
		Student st= new Student();
		st.setId(101);
		st.setName("ram");
		st.setCity("nepal");
		
		System.out.println(st);
		Session session = factory.getCurrentSession();
		
		 Transaction tx= session.beginTransaction();
		session.save(st);
		
		tx.commit();
		session.close();
		
		
		
	}
	

}
