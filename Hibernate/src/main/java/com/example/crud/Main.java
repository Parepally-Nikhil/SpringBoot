package com.example.crud;

import java.util.List;
import java.util.Scanner;

 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main obj = new Main();
        Long courseId1 = obj.saveCourse("Physics");
        Long courseId2 = obj.saveCourse("Chemistry");
        Long courseId3 = obj.saveCourse("Maths");
        do
        {
        System.out.println("1. Select");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Exit");
        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();
        switch(opt)
        {
        case 1 : obj.listCourse(); break;
        case 2 : obj.updateCourse(courseId3, "Mathematics"); break;
        case 3 : obj.deleteCourse(courseId2); break;
        case 4 : System.exit(0);
        default : System.out.println("Invalid Option");
        }
        }while(true);
    }
   
    @SuppressWarnings("deprecation")
	public Long saveCourse(String courseName)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Long courseId = null;
        try {
            transaction = session.beginTransaction();
            Course course = new Course();
            course.setCourseName(courseName);
            courseId = (Long) session.save(course);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courseId;
    }
   
    public void listCourse()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query<Course> query=session.createQuery("from Course");
            List<Course> courses = query.list();
            for (Course print:courses)
            {
                System.out.println(print.getCourseId());
                System.out.println(print.getCourseName());
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
   
    public void updateCourse(Long courseId, String courseName)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            @SuppressWarnings("deprecation")
			Query<Course> query = session.createQuery("update Course set courseName=:cnm where courseId=:id");
            query.setParameter("cnm", courseName);
            query.setParameter("id", 3);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
   
    
	public void deleteCourse(Long courseId)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
          
			Query<Course> query = session.createQuery("delete from Course where courseId=:id");
            query.setParameter("id", courseId);
            query.executeUpdate();           
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

 

    }

 

}