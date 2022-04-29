package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.StudentDao;

@SpringBootApplication
public class AbApplication implements CommandLineRunner  {
@Autowired
private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(AbApplication.class, args);
	}
		
		@Override
		public void run(String...args) throws Exception {
			// this.studentDao.creatTable();
            this.studentDao.insertData("hari", "nepal");
            
			
		
	}

}
