/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.mmapicerija.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marija
 */
@Entity
@Table(name = "pica")
public class Pica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "sastojci")
    private String sastojci;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private double cena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tezina")
    private double tezina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ocena")
    private double ocena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktivna")
    private boolean aktivna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "slika_url")
    private String slikaUrl;
    @OneToMany(mappedBy = "picaId")
    private List<PicaPorudzbina> picaPorudzbinaList;

    public Pica() {
    }

    public Pica(Integer id) {
        this.id = id;
    }

    public Pica(Integer id, String naziv, String opis, String sastojci, double cena, double tezina, double ocena, boolean aktivna, String slikaUrl) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.sastojci = sastojci;
        this.cena = cena;
        this.tezina = tezina;
        this.ocena = ocena;
        this.aktivna = aktivna;
        this.slikaUrl = slikaUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public boolean getAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }

    @XmlTransient
    public List<PicaPorudzbina> getPicaPorudzbinaList() {
        return picaPorudzbinaList;
    }

    public void setPicaPorudzbinaList(List<PicaPorudzbina> picaPorudzbinaList) {
        this.picaPorudzbinaList = picaPorudzbinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pica)) {
            return false;
        }
        Pica other = (Pica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pica{" + "id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", sastojci=" + sastojci + ", cena=" + cena + ", tezina=" + tezina + ", ocena=" + ocena + ", aktivna=" + aktivna + ", slikaUrl=" + slikaUrl + '}';
    }

}
