package com.tap.vacciineApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.entity.RegisterEntity;


@Component
public class LoginDAOImpl implements LoginDAO {
	
	public LoginDAOImpl() {
		System.out.println("LoginDAOImpl is invoked");
	}
	
	
	private SessionFactory sessionFactory;
	@Autowired
	protected LoginDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}



	@Override
	public RegisterEntity getRegisterEntityByEmail(String email) {
		System.out.println("invoked getRegisterEntityByEmail");
		Session session = null;
		RegisterEntity entity = null;
		Query query = null;
		String hqlQuery = "FROM com.tap.vacciineApp.entity.RegisterEntity WHERE email = '"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hqlQuery);
			entity =(RegisterEntity) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}



	@Override
	public int increaseLoginAttepmt(String email, int loginAttemptcount) {
		Session session = null;
		Query query = null;
		int countIncrease = ++loginAttemptcount;
		int count =0;
		String hql = "UPDATE com.tap.vacciineApp.entity.RegisterEntity set loginAttempt = "+countIncrease+" WHERE email = '"+email+"'";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			session.beginTransaction();
			count = query.executeUpdate();
			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return count;
	}

}