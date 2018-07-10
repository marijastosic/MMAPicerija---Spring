/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.mmapicerija.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marija
 */
@Entity
@Table(name = "porudzbina")
public class Porudzbina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefon")
    @Size(min = 1, max = 50, message = "(Telefon mora imati između 1 i 50 karaktera")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "adresa")
    @Size(min = 1, max = 50, message = "(Adresa mora imati između 1 i 50 karaktera")
    private String adresa;
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id")
    @ManyToOne
    private Korisnik korisnikId;
    @OneToMany(mappedBy = "porudzbinaId")
    private List<StavkaPorudzbine> stavkaPorudzbineList;

    public Porudzbina() {
    }

    public Porudzbina(Integer id) {
        this.id = id;
    }

    public Porudzbina(Integer id, Date datum, String telefon, String adresa) {
        this.id = id;
        this.datum = datum;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    

    public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
    }

    @XmlTransient
    public List<StavkaPorudzbine> getStavkaPorudzbineList() {
        return stavkaPorudzbineList;
    }

    public void setStavkaPorudzbineList(List<StavkaPorudzbine> stavkaPorudzbineList) {
        this.stavkaPorudzbineList = stavkaPorudzbineList;
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
        if (!(object instanceof Porudzbina)) {
            return false;
        }
        Porudzbina other = (Porudzbina) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Porudzbina[ id=" + id + " ]";
    }
    
}
