package com.demo.mmapicerija.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stavka_korpe")
public class StavkaKorpe implements Serializable {

	private static final long serialVersionUID = -8045075974879708515L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "kolicina")
	private int kolicina;
	@JoinColumn(name = "pica_id", referencedColumnName = "id")
	@ManyToOne
	private Pica picaId;
	@JoinColumn(name = "korisnik_id", referencedColumnName = "id")
	@ManyToOne
	private Korisnik korisnikId;

	public StavkaKorpe() {
		super();
	}

	public StavkaKorpe(Integer id) {
		this.id = id;
	}

	public StavkaKorpe(Integer id, int kolicina) {
		this.id = id;
		this.kolicina = kolicina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Pica getPicaId() {
		return picaId;
	}

	public void setPicaId(Pica picaId) {
		this.picaId = picaId;
	}

	public Korisnik getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Korisnik korisnikId) {
		this.korisnikId = korisnikId;
	}

	@Override
	public String toString() {
		return "StavkaKorpe [id=" + id + ", kolicina=" + kolicina + ", picaId=" + picaId + ", korisnikId=" + korisnikId + "]";
	}

}
