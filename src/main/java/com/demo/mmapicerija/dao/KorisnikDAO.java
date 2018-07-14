package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Korisnik;

public interface KorisnikDAO {
	public List<Korisnik> getListaSvihKorisnika();
	public void dodajKorisnika(Korisnik korisnik);
	public Korisnik getKorisnikByEmail(String email);
	public Korisnik getKorisnikByUsername(String username);
	public void azurirajKorisnika(Korisnik korisnik);
}
