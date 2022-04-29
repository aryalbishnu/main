package com.example.demo.has;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Onetomany {
	
	public static void main(String[] args) {

		
System.out.println("start.....");
		
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creatind question
		Question q1= new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
		
		
		//Creating Answer
		Answer answer= new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("java is programing language");
		answer.setQuestion(q1);
		
		Answer answer1= new Answer();
		answer1.setAnswerId(33);
		answer1.setAnswer("with the java is programing language");
		answer1.setQuestion(q1);
		
		Answer answer2= new Answer();
		answer2.setAnswerId(363);
		answer2.setAnswer("i dont no  programing language");
		answer2.setQuestion(q1);
		
		List<Answer> list= new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswers(list);
		
		Session s= factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);
		tx.commit();
		
		s.close();
		factory.close();
		
	}

}


