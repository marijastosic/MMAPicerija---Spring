package com.demo.mmapicerija.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mmapicerija.dao.KorisnikDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.UserRoles;
import com.demo.mmapicerija.entities.Users;
import com.demo.mmapicerija.service.MailService;

@Repository
@Transactional
public class KorisnikDAOImpl implements KorisnikDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MailService mailService;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Korisnik> getListaSvihKorisnika() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Korisnik.class).list();
	}

	@Override
	public void dodajKorisnika(Korisnik korisnik) {
		Session session = sessionFactory.getCurrentSession();
		int korisnikId = (Integer)session.save(korisnik);
		session.flush();
		
		Users user = new Users();
		user.setKorisnikId(korisnikId);
		user.setUsername(korisnik.getUsername());
		user.setPassword(korisnik.getPassword());
		user.setEnabled(true);
		
		session.save(user);
		session.flush();
		
		UserRoles userRole = new UserRoles();
		userRole.setUsername(user.getUsername());
		userRole.setRole("ROLE_USER");
		
		session.save(userRole);
		session.flush();
		
		mailService.posaljiMailZaRegistraciju(korisnik);
	}

	@Override
	public Korisnik getKorisnikByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		return (Korisnik)session.createCriteria(Korisnik.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

	@Override
	public Korisnik getKorisnikByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		return (Korisnik)session.createCriteria(Korisnik.class).add(Restrictions.eq("username", username)).uniqueResult();
	}
}
