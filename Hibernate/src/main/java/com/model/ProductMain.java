package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class ProductMain {
	 public static void main(String[] args) {
	        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
	                .configure("ProductHiber.cfg.xml").build();
	        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	 

	        SessionFactory factory = meta.getSessionFactoryBuilder().build();
	        Session session = factory.openSession();
	        Transaction t = session.beginTransaction();

	 

	        Product p1 = new Product();
	        p1.setProdId(1);
	        p1.setProdName("horlicks");
	        p1.setProdPrice("149");
	        
	        Product p2 = new Product();
	        p2.setProdId(2);
	        p2.setProdName("boost");
	        p2.setProdPrice("100");

	 

	        session.save(p1);
	        session.save(p2);
	        t.commit();
	        System.out.println("successfully saved");
	        factory.close();
	        session.close();
	    }
}
