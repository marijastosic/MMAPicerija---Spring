/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marija
 */
@Entity
@Table(name = "stavka_porudzbine")
public class StavkaPorudzbine implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @JoinColumn(name = "porudzbina_id", referencedColumnName = "id")
    @ManyToOne
    private Porudzbina porudzbinaId;

    public StavkaPorudzbine() {
    }

    public StavkaPorudzbine(Integer id) {
        this.id = id;
    }

    public StavkaPorudzbine(Integer id, int kolicina) {
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

    public Porudzbina getPorudzbinaId() {
        return porudzbinaId;
    }

    public void setPorudzbinaId(Porudzbina porudzbinaId) {
        this.porudzbinaId = porudzbinaId;
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
        if (!(object instanceof StavkaPorudzbine)) {
            return false;
        }
        StavkaPorudzbine other = (StavkaPorudzbine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PicaPorudzbina[ id=" + id + " ]";
    }
    
}
