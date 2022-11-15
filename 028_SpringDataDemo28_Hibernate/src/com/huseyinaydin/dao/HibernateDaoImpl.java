package com.huseyinaydin.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.huseyinaydin.model.Circle;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private Session session;
	
	/*public int getCircleCount() {
		String hql = "select count(*) from circle";
		Query<Long> query = sessionFactory.openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}*/
	
	public int getCircleCount() {
		this.session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Circle.class);
		List<Circle> circles = criteria.list();
		return circles.size();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
