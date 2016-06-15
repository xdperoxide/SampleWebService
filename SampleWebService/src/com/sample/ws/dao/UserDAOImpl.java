package com.sample.ws.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.sample.ws.mdl.User;

@Transactional
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(User u) {
		Session session = this.sessionFactory.openSession();
		session.persist(u);
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> list() {
		Session session = this.sessionFactory.openSession();
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}

}
