package com.demo.mmapicerija.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mmapicerija.dao.StavkaKorpeDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.StavkaKorpe;

@Repository
@Transactional
public class StavkaKorpeDAOImpl implements StavkaKorpeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void sacuvajStavkuKorpe(StavkaKorpe stavkaKorpe) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(stavkaKorpe);
		session.flush();
	}

	@Override
	public List<StavkaKorpe> procitajSveIzStavkeKorpe(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(StavkaKorpe.class).add(Restrictions.eq("korisnikId", korisnik)).list();
	}

	@Override
	public void obrisiStavkuKorpeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		StavkaKorpe stavka = (StavkaKorpe)session.createCriteria(StavkaKorpe.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.delete(stavka);
		session.flush();
		
	}

	@Override
	public void ocistiKorpu(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		List<StavkaKorpe> listaSvihStavkiZaKorisnika = session.createCriteria(StavkaKorpe.class).add(Restrictions.eq("korisnikId", korisnik)).list();
		for(StavkaKorpe sk : listaSvihStavkiZaKorisnika) {
			session.delete(sk);
			session.flush();
		}
	}

	

}
