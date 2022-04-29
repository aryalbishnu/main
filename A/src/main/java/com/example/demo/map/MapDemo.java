package com.example.demo.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {

		System.out.println("start.....");
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("what is java ?");
		
		//creating answer
		
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("java is programming language");
		
		q1.setAnswer(answer);
		
		//creating question
				Question q2 = new Question();
				q2.setQuestionId(12);
				q2.setQuestion("what is php ?");
				
				//creating answer
				
				Answer answer1 = new Answer();
				answer1.setAnswerId(34);
				answer1.setAnswer("php is programming language");
				
				q2.setAnswer(answer1);
				
		
		Session s= factory.openSession();
		Transaction tx= s.beginTransaction();
		
		//save
		s.save(q1);
		s.save(q2);
		s.save(answer);
		s.save(answer1);
		
		tx.commit();
		
		//fetching------
		
	//	Question newQ =(Question)s.get(Question.class, 12);
	//	System.out.println(newQ.getQuestion());
	//	System.out.println(newQ.getAnswer().getAnswer());
		
		s.close();
		
		
		factory.close();
	}

}
