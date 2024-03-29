package com.product.crud;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProductUtil {
	 private static final SessionFactory sessionFactory;
	    static {
	        try {
	            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("Productcrud.cfg.xml")
	                    .build();
	            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

	 

	            sessionFactory = meta.getSessionFactoryBuilder().build();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	 

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

}
