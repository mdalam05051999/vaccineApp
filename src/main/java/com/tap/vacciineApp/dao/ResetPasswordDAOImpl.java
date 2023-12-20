package com.tap.vacciineApp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class ResetPasswordDAOImpl implements RessetPasswordDAO {
	
	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javaMailSenderImpl;
	@Autowired
	protected ResetPasswordDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javaMailSenderImpl) {
		super();
		this.sessionFactory = sessionFactory;
		this.javaMailSenderImpl = javaMailSenderImpl;
	}



	@Override
	public boolean resetPasswordByEmail(String email, String newPassword) {
	    Session session = null;
	    Transaction transaction = null;
	    boolean isDataSaved = false;
	    String hql = "UPDATE com.tap.vacciineApp.entity.RegisterEntity set loginAttempt = '0', password = :newPassword WHERE email = :email";
	    try {
	        session = sessionFactory.openSession();
	        Query query = session.createQuery(hql);
	        query.setParameter("newPassword", newPassword);
	        query.setParameter("email", email);
	        session.beginTransaction();
	        int update = query.executeUpdate();
	        System.out.println(update);
	        
	        String toEmail = email;
			String subject = "Vaccine - Reset Password";
			String body = "Password has been Successfully Reset\n"
						  +"Your Password is : " + newPassword + "\n"
						   +"Note: use these Password for login.";
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(toEmail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			
			javaMailSenderImpl.send(simpleMailMessage);
			System.out.println("Reset Password mail sent");
	        
	        session.getTransaction().commit();
	        isDataSaved = true;
	    }catch (Exception e) {
	        transaction.rollback();
	        String message = e.getMessage();
	        System.out.println(message);
	        String localizedMessage = e.getLocalizedMessage();
	        System.out.println(localizedMessage);
	        
	        System.out.println("Transaction has been rolled back "+e.getMessage());
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
