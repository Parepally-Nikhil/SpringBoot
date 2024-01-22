package com.example.association1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;



public class MainApp {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf=config.buildSessionFactory(registry);
        Session session=sf.openSession();
        Transaction t=session.beginTransaction();
        Laptop l=new Laptop();
        Student st=new Student();
        
        l.setlId(45);
        l.setlName("Dell");
        
        st.setsRollno(46);
        st.setsName("Nikhil");
        st.setsMarks("100");
        
        
       // st.setLaptop(l);->works for one to one relationship in database.
        
        st.getLaptop().add(l);
       
        l.setStudent(st);
        
        session.persist(l);
        session.persist(st);
        
       
        
        t.commit();
	}

}
