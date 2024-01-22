package com.example.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.annotation.Employee;

public class EmployeeMain {
	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
	        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
	                .configure("Hiber.cfg.xml").build();
	        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	 

	        SessionFactory factory = meta.getSessionFactoryBuilder().build();
	        Session session = factory.openSession();
	        Transaction t = session.beginTransaction();

	 

	        Employee e1 = new Employee();
	        e1.setId(3);
	        e1.setFirstName("Jitendra");
	        e1.setLastName("Tindolia");
	        
	        Employee e2 = new Employee();
	        e2.setId(4);
	        e2.setFirstName("Sushant");
	        e2.setLastName("Gunjikar");

	 

	        session.save(e1);
	        session.save(e2);
	        t.commit();
	        System.out.println("successfully saved");
	        factory.close();
	        session.close();
}
}