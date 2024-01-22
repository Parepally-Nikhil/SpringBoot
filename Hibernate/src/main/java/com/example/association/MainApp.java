package com.example.association;

import java.util.List;

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
        Laptop l1=new Laptop();
        Student st=new Student();
        l.setlId(45);
        l.setlName("Dell");
        
        l1.setlId(46);
        l1.setlName("lenovo");
        
        st.setsRollno(46);
        st.setsName("Nikhil");
        st.setsMarks("100");
        
      //  st.setLaptop(l);
        
        List<Laptop> li=st.getLapy();
        li.add(l);
        li.add(l1);
        l.setStudent(st);
        l1.setStudent(st);
        session.save(l);
        session.save(l1);
        session.save(st);
        t.commit();
	}

}
