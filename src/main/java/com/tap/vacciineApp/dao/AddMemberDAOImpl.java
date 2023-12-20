package com.tap.vacciineApp.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;


import com.tap.vacciineApp.entity.AddMemberEntity;
import com.tap.vacciineApp.entity.RegisterEntity;

@Component
public class AddMemberDAOImpl implements AddMemberDAO {
	
	public AddMemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private SessionFactory sessionFactory;
	@Autowired
	public AddMemberDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	@Override
	public boolean saveAddMember(AddMemberEntity addMemberEntity) {
		
		System.out.println("saveAddMember is invoked");
		Session session = null;
		Transaction transaction = null;
		boolean isDataSaved = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Serializable save = session.save(addMemberEntity);
			System.out.println(save);
			transaction.commit();
			isDataSaved = true;
		} catch (HibernateException | MailException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			String mesage = e.getMessage();
			System.out.println(mesage);
			String localizedMessage = e.getLocalizedMessage();
			System.out.println(localizedMessage);
			
			System.out.println("Transaction hase been rollbacked "+e.getMessage());
		}
		finally {
			if (session !=null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}
	
	
	@Override
	public RegisterEntity getMemeberCountByEmail(String email) {
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
	public int updateMemberCount(String email, int countMember) {
		System.out.println("increaseMemberCount is invoked");
	    Session session = null;
	    Query query = null;
	    int count = 0;
	    String hql = "UPDATE com.tap.vacciineApp.entity.RegisterEntity set memberCount = memberCount + 1 WHERE email = '"+email+"'";
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



	@Override
	public List<AddMemberEntity> getMemberList(String email) {
		
		System.out.println("invoked getMemberList");
		Session session = null;
		String hql = "FROM com.tap.vacciineApp.entity.AddMemberEntity WHERE email = '"+email+"'";
		try {
			 session = sessionFactory.openSession();
			 Query query = session.createQuery(hql);
			 List<AddMemberEntity> resultList = query.getResultList();
			 for (AddMemberEntity addMemberEntity : resultList) {
				System.out.println(addMemberEntity);
			}
			 return resultList;
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		
		
	}


	@Override
	public boolean deleteMemberByIDProofNo(int memberID) {
		System.out.println("invoked deleteAIrportEntityByID");
		Session session = null;
		AddMemberEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(AddMemberEntity.class,memberID);
			if (entity != null) {
				session.beginTransaction();
				session.delete(entity);
				session.getTransaction().commit();
				System.out.println("Member Deleted");
				return true;
			}

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return true;
	}


	@Override
	public int deleteMemberCount(String email, int countMember) {
		System.out.println("decreaseMemberCount is invoked");
	    Session session = null;
	    Query query = null;
	    int count = 0;
	    String hql = "UPDATE com.tap.vacciineApp.entity.RegisterEntity set memberCount = memberCount - 1 WHERE email = '"+email+"'";
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


	@Override
	public AddMemberEntity getMemberEntityByID(int memberID) {
		System.out.println("invoked getMemberEntityByID");
		Session session = null;
		AddMemberEntity entity = null;
		try {
			session = sessionFactory.openSession();
			entity = session.get(AddMemberEntity.class, memberID);
			if (entity != null) {
				System.out.println("AddMemberEntity found");
				return entity;
			}

		} finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}


	@Override
	public boolean updateAddMemberEntity(AddMemberEntity entity) {
		System.out.println("invoked updateAddMemberEntity");
		Session session = null;
		boolean isDataSaved = false;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction =session.beginTransaction();
			session.update(entity);
			transaction.commit();
			isDataSaved = true;

		} 
		catch (HibernateException e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			System.err.println("Error Updating entity:"+e.getMessage());
		}
		finally {
			if (session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataSaved;
	}

		
}
