package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Porudzbina;

public interface PorudzbinaDAO {
	public int sacuvajPorudzbinu(Porudzbina porudzbina);
	public Porudzbina getPorudzbinaById(int id);
	public List<Porudzbina> getSvePorudzbine();
}
