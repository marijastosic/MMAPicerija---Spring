package com.demo.mmapicerija.dao;

import com.demo.mmapicerija.entities.Porudzbina;

public interface PorudzbinaDAO {
	public int sacuvajPorudzbinu(Porudzbina porudzbina);
	public Porudzbina getPorudzbinaById(int id);
}
