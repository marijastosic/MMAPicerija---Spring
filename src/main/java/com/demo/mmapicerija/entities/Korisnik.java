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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Marija
 */
@Entity
@Table(name = "korisnik")
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Username mora imati između 1 i 50 karaktera)")
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Password mora imati između 1 i 50 karaktera)")
    @Column(name = "password")
    private String password;
    @Pattern(regexp="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message="(Neispravan email)")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Email mora imati između 1 i 50 karaktera)")
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Ime mora imati između 1 i 50 karaktera)")
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Prezime mora imati između 1 i 50 karaktera)")
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Telefon mora imati između 1 i 50 karaktera)")
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50, message = "(Adresa mora imati između 1 i 50 karaktera)")
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10, message = "(Morate odabrati pol)")
    @Column(name = "pol")
    private String pol;
    @OneToMany(mappedBy = "korisnikId")
    private List<Porudzbina> porudzbinaList;
    @OneToMany(mappedBy = "korisnikId")
    private List<StavkaKorpe> stavkaKorpeList;

    public Korisnik() {
    }

    public Korisnik(Integer id) {
        this.id = id;
    }

    public Korisnik(Integer id, String username, String password, String email, String ime, String prezime, String telefon, String adresa, String pol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.adresa = adresa;
        this.pol = pol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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
    

    public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	@XmlTransient
    public List<Porudzbina> getPorudzbinaList() {
        return porudzbinaList;
    }

    public void setPorudzbinaList(List<Porudzbina> porudzbinaList) {
        this.porudzbinaList = porudzbinaList;
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
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Korisnik[ id=" + id + " ]";
    }
    
}
