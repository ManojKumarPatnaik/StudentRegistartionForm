package com.studentform.Studentregistration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class StudentregistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentregistrationApplication.class, args);  
		
		System.out.println("Welcome to Student Registration ");
		
		
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();


			session.beginTransaction();
			

		      session.getTransaction().commit();
		     
				session.close();
				sessionFactory.close();

			}catch(HibernateException e) {
				e.printStackTrace();
			}
		
	}

}
