package com.example.annotation;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AnnotationMain {
	public static void main(String args[]) {
		Configuration config=new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf=config.buildSessionFactory(registry);
        Session session=sf.openSession();
        Transaction t=session.beginTransaction();
        Employee e1 = new Employee();
        e1.setId(6);
        e1.setFirstName("Jitendra");
        e1.setLastName("Tindolia");
        
        Employee e2 = new Employee();
        e2.setId(7);
        e2.setFirstName("Sushant");
        e2.setLastName("Gunjikar");

 

        session.save(e1);
        session.save(e2);
        t.commit();
        System.out.println("successfully saved");
        sf.close();
        session.close();
	}
}
