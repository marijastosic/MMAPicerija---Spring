package com.demo.mmapicerija.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mmapicerija.dao.PorudzbinaDAO;
import com.demo.mmapicerija.entities.Porudzbina;

@Repository
@Transactional
public class PorudzbinaDAOImpl implements PorudzbinaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int sacuvajPorudzbinu(Porudzbina porudzbina) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer)session.save(porudzbina);
		session.flush();
		return id;
	}

	@Override
	public Porudzbina getPorudzbinaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Porudzbina porudzbina = (Porudzbina)session.createCriteria(Porudzbina.class).add(Restrictions.eq("id", id)).uniqueResult();
		Hibernate.initialize(porudzbina.getStavkaPorudzbineList());
		return porudzbina;
	}

	@Override
	public List<Porudzbina> getSvePorudzbine() {
		Session session = sessionFactory.getCurrentSession();
		List<Porudzbina> listaPorudzina = session.createCriteria(Porudzbina.class).list();
		for(Porudzbina p : listaPorudzina) {
			Hibernate.initialize(p.getStavkaPorudzbineList());
		}
		return listaPorudzina;
	}

}
