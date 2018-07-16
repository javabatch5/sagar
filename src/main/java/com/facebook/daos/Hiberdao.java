package com.facebook.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.daos.interfaces.Interfaces;
import com.facebook.dbutil.DbHiberUtil;
import com.pojos.Student;

public class Hiberdao implements Interfaces {

	public void registerStd(Student std) throws Exception{
		System.out.println("Enetering  into rgisteredstd :: hiberdao");
		System.out.println("student pojo mapping set!!");
		System.out.println(std.getName() + "---" + std.getUname() + "---" + std.getPwrd() + "----" + std.getMnumber());

		try {
			SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.save(std);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e);
		}
		System.out.println("Exiting from registered student :: hiberDao");
	}

	public List<Student> loginStd(Student std) throws Exception {
		System.out.println(std.getUname());
		System.out.println(std.getPwrd());
		SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session.createQuery("from Student where uname=:mail and pwrd=:password ");
		query.setParameter("mail", std.getUname());
		query.setParameter("password", std.getPwrd());
		List<Student> list = query.list();
		return list;

	}

	@SuppressWarnings("deprecation")
	public List<Student> getAllStudents() throws Exception {
		Session session = new Configuration().configure().buildSessionFactory().openSession();

		org.hibernate.Query query2 = session.createQuery("from Student");
		List<Student> list2 = query2.list();

		return list2;

	}

	public void deleteStd(@RequestParam("uname") String uname) throws Exception {
		SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from Student where uname=:uname");
		query.setParameter("uname", uname);
		System.out.println("triggering delete");
		int update = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println(update);
		Query createQuery = session.createQuery("from Student");
		List<Student> list = createQuery.list();
		return;

	}

	public List<Student> editStd(@RequestParam("myname") String uname) throws Exception {
		SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Student where uname=:username");
		query.setParameter("username", uname);
		List<Student> list = query.list();
		return list;

	}

	public void update(Student std) throws Exception {
		SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(std);
		session.beginTransaction().commit();
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		return;

	}

	public void deleteAll(List<String> uname) throws Exception{
		SessionFactory sessionFactory = DbHiberUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete from Student where uname in (:uname)");
		query.setParameterList("uname", uname);
		int executeUpdate = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("deleted record count:" + executeUpdate);
		Query query2 = session.createQuery("from Student");
		List<Student> list = query2.list();

		return;

	}

	 
	
}