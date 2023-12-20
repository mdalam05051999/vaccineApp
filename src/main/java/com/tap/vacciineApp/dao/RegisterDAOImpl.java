package com.tap.vacciineApp.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.entity.RegisterEntity;


@Component
public class RegisterDAOImpl implements RegisterDAO {
	
	public RegisterDAOImpl() {
		
	}
	
	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javaMailSenderImpl;
	@Autowired
	protected RegisterDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javaMailSenderImpl) {
		super();
		this.sessionFactory = sessionFactory;
		this.javaMailSenderImpl = javaMailSenderImpl;
	}



	@Override
	public boolean saveRegisterEntity(RegisterEntity registerEntity) {
		System.out.println("saveRegisterEntity is invoked");
		Session session = null;
		Transaction transaction = null;
		boolean isDataSaved = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Serializable save = session.save(registerEntity);
			System.out.println(save);
			
			String toEmail = registerEntity.getEmail();
			String subject = "Vaccine - Registration Successfulll";
			String body = "Registration has been Successfull!!!\n"
						  +"Your Username is : " + registerEntity.getEmail() + "\n"
						  +"Your Password is : " + registerEntity.getPassword() + "\n"
						   +"Note: use these credentials for login.";
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(toEmail);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(body);
			
			javaMailSenderImpl.send(simpleMailMessage);
			System.out.println("Mail sent");
			
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
	
		
}