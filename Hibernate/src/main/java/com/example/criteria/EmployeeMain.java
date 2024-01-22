package com.example.criteria;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;




public class EmployeeMain {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        EmployeeMain obj = new EmployeeMain();
        
        do
        {
        System.out.println("1. insert data");
        System.out.println("2. list data");
        System.out.println("3. list data count");
        System.out.println("4. list data sum");
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        switch(opt)
        {
        case 1 : obj.insertData(sc); break;
        case 2 : obj.listData(); break;
        case 3 : obj.listDataCount(); break;
        case 4 : obj.listDataSum();break;
        case 5 :System.exit(0);
        default : System.out.println("Invalid Option");
        }
        }while(true);
    }
	public void insertData(Scanner sc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee emp=new Employee();
            System.out.println("Enter emp id:");
            emp.setId(sc.nextInt());
            System.out.println("Enter emp name:");
            emp.setName(sc.next());
            System.out.println("Enter emp salary:");
            emp.setSalary(sc.nextInt());
            session.save(emp);
            transaction.commit();
            System.out.println("emp details inserted successfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

	}
	public void listData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Employee> employee = session.createQuery("from Employee").list();
            /*for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();)
            {
                Course course = iterator.next();
                System.out.println(course.getCourseName());
            }*/
            employee.forEach((empl)->System.out.println(empl.getId()+"\t"+empl.getName()+"\t"+empl.getSalary()));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
			
	}
	public void listDataCount() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Employee> employee = session.createQuery("from Employee").list();
            /*for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();)
            {
                Course course = iterator.next();
                System.out.println(course.getCourseName());
            }*/
            System.out.println("count: "+employee.size());
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}
	public void listDataSum() {
		
	}
	public void listDataFilteredSalary() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria c = session.createCriteria(Employee.class);
            c.add(Restrictions.gt("salary",10000));
            List<Employee> employee=c.list();
            employee.forEach((empl)->System.out.println(empl.getId()+"\t"+empl.getName()+"\t"+empl.getSalary()));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}
}
