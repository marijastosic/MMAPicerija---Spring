package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.StavkaPorudzbine;

public interface StavkaPorudzbineDAO {
	public void sacuvajStavkuPorudzbine(StavkaPorudzbine stavkaPorudzbine);
	public List<StavkaPorudzbine> procitajSveIzStavkePorudzbine(Korisnik korisnik);
}
