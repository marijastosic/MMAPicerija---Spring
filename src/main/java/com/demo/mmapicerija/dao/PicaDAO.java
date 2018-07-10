package com.demo.mmapicerija.dao;

import java.util.List;

import com.demo.mmapicerija.entities.Pica;

public interface PicaDAO {
	public List<Pica> getListaSvihPica();
	public List<Pica> getListaSvihAktivnihPica();
	public Pica getPicaById(int id);
	public void deletePicaById(int id);
}
