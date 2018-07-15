package com.demo.mmapicerija.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mmapicerija.dao.StavkaPorudzbineDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.StavkaPorudzbine;

@Repository
@Transactional
public class StavkaPoruzbineDAOImpl implements StavkaPorudzbineDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void sacuvajStavkuPorudzbine(StavkaPorudzbine stavkaPorudzbine) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(stavkaPorudzbine);
		session.flush();
	}

	@Override
	public List<StavkaPorudzbine> procitajSveIzStavkePorudzbine(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(StavkaPorudzbine.class).add(Restrictions.eq("korisnikId", korisnik)).list();
	}

}
