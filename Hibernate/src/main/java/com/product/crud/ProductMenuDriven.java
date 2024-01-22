package com.product.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.crud.Course;
import com.example.crud.HibernateUtil;



public class ProductMenuDriven {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		ProductMenuDriven pmd=new ProductMenuDriven();
		while(true) {
			System.out.println("Enter your choice:");
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.select");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:System.out.println("Enter product id:");
				   int pid=sc.nextInt();
				   System.out.println("Enter product name:");
				   String pname=sc.next();
				   System.out.println("Enter product price:");
				   String price=sc.next();
				   Product p=new Product();
				   p.setProdId(pid);
				   p.setProdName(pname);
				   p.setProdPrice(price);
				   pmd.saveProduct(p);
				   break;
			case 2:System.out.println("Enter product id:");
				   pid=sc.nextInt();
				   System.out.println("Enter product name to be updated:");
				   pname=sc.next();
				   System.out.println("Enter product price to be updated:");
			   	   price=sc.next();
			   	   pmd.updateProduct(pid,pname,price);
			   	   break;
			   	   
			case 3:System.out.println("Enter product id:");
				   pid=sc.nextInt();
				   pmd.deleteProduct(pid);
				   break;
				   
			case 4:pmd.selectProduct();
			}
		}
		
	}


	public void selectProduct() {
		Session session = ProductUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Product> product = session.createQuery("from Product").list();
            /*for (Iterator<Course> iterator = courses.iterator(); iterator.hasNext();)
            {
                Course course = iterator.next();
                System.out.println(course.getCourseName());
            }*/
            product.forEach((produc)->System.out.println(produc.getProdId()+"\t"+produc.getProdName()+"\t"+produc.getProdPrice()));
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}


	public void deleteProduct(int pid) {
		
		Session session = ProductUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Product product = (Product) session.get(Product.class, pid);
            session.delete(product);
            transaction.commit();
            System.out.println("product deleted successfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
	}


	public void saveProduct(Product p) {
		Session session = ProductUtil.getSessionFactory().openSession();
        Transaction t = null;
        t=session.beginTransaction();
        session.save(p);
        t.commit();
        System.out.println("product inserted successfully");
	}
	
	public void updateProduct(int pid, String pname, String price) {
		 Session session = ProductUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	            transaction = session.beginTransaction();
	            Product product = (Product) session.get(Product.class, pid);
	            product.setProdName(pname);
	            product.setProdPrice(price);
	            
	            transaction.commit();
	            System.out.println("product details updated successfully");
	        } catch (HibernateException e) {
	            transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
		
	}
}
