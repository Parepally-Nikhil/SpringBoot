package com.example.crud;

import java.util.List;

import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
@SuppressWarnings("deprecation")
public class CourseMain {

 

    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CourseMain obj = new CourseMain();
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
            
            List<Course> courses = session.createQuery("from Course").list();
            
          //  Course course = (Course) session.get(Course.class, 1);
            
            /*for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();)
            {
                Course course = iterator.next();
                System.out.println(course.getCourseName());
            }*/
            
            
           courses.forEach((course)->System.out.println(course.getCourseId()+"\t"+course.getCourseName()));
            
           // System.out.println(course.getCourseName());
            
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
            Course course = (Course) session.get(Course.class, courseId);
            course.setCourseName(courseName);
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
            Course course = (Course) session.get(Course.class, courseId);
            session.delete(course);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
    }
}