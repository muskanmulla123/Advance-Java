package com.demo.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.NonPerishableProduct;
import com.demo.model.PerishableProduct;

public class TestInheritanceSingleTable {

	public static void main(String[] args) {
		PerishableProduct p1=new PerishableProduct(12, "Lays", 23, 36.6, LocalDate.of(2025, 04,04), LocalDate.of(2025, 10,04));
		NonPerishableProduct p2=new NonPerishableProduct(13, "Chair", 45, 4000, LocalDate.of(2025, 04,04),"furniture");
 		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
		
		

	}

}
