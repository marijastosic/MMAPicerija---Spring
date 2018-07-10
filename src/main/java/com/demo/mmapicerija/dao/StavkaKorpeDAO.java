package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.StavkaKorpe;

public interface StavkaKorpeDAO {
	public void sacuvajStavkuKorpe(StavkaKorpe stavkaKorpe);
	public List<StavkaKorpe> procitajSveIzStavkeKorpe(Korisnik korisnik);
	public void obrisiStavkuKorpeById(int id);
	public void ocistiKorpu(Korisnik korisnik);
}

