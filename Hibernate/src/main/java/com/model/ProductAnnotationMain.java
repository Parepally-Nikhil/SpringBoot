package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class ProductAnnotationMain {
	public static void main(String args[]) {
		Configuration config=new Configuration().configure().addAnnotatedClass(Product.class);
        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf=config.buildSessionFactory(registry);
        Session session=sf.openSession();
        Transaction t=session.beginTransaction();
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
        sf.close();
        session.close();
	}
}
