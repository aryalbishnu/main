package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.demo.map.Answer;
import com.example.demo.map.Question;

public class CasCadeExample {
	public static void main(String[] args) {
		System.out.println("start.....");
	
			Configuration cfg= new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			Session s= factory.openSession();
			
			Question q1= new Question();
			q1.setQuestionId(11);
			q1.setQuestion("what is cascadi?");
			
			Answer a1= new Answer(23,"that is importan");
			Answer a2= new Answer(21,"that is impor kdk tan");
			Answer a3= new Answer(24,"that is importan od life");
			List<Answer> list = new ArrayList<>();
			list.add(a1);
			list.add(a2);
			list.add(a3);
			
			//q1.setAnswer(list);
			Transaction tx= s.beginTransaction();
			
			s.save(q1);
		  s.save(a1);
		  s.save(a2);
		  s.save(a3);
		tx.commit();
			s.close();
			factory.close();
	}
}
