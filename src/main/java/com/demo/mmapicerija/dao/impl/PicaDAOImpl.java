package com.demo.mmapicerija.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mmapicerija.dao.PicaDAO;
import com.demo.mmapicerija.entities.Pica;

@Repository
@Transactional
public class PicaDAOImpl implements PicaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pica> getListaSvihPica() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Pica.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pica> getListaSvihAktivnihPica() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Pica.class).add(Restrictions.eq("aktivna", true)).list();
	}

	@Override
	public Pica getPicaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return (Pica)session.createCriteria(Pica.class)
				.add(Restrictions.eq("id", id))
				.add(Restrictions.eq("aktivna", true)).uniqueResult();
	}

}
