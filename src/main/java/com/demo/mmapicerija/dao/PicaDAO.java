package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Pica;

public interface PicaDAO {
	public List<Pica> getListaSvihPica();
	public List<Pica> getListaSvihAktivnihPica();
	public Pica getPicaById(int id);
	public Pica getAktivnaPicaById(int id);
	public void obrisiPicuById(int id);
	public void sacuvajPicu(Pica pica);
	public void dodajIzmeniPicu(Pica pica);
}
