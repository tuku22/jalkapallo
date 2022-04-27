package com.example.Jalkapallo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Ottelu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pvm;
	private String kello;
	private String kjoukkue;
	private String vjoukkue;
	private String tulos;
	private String maalintekija;

	@ManyToOne
	@JoinColumn(name = "kenttaid")
	@JsonIgnoreProperties("ottelut")
	private Kentta kentta;

	public Ottelu() {
		super();
	}

	public Ottelu(Long id, String kello, String kjoukkue, String vjoukkue, String tulos, String maalintekija,
			Kentta kentta) {
		super();
		this.id = id;
		this.kello = kello;
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
		this.maalintekija = maalintekija;
		this.kentta = kentta;
	}

	public Ottelu(String pvm, String kello, String kjoukkue, String vjoukkue, String tulos, String maalintekija,
			Kentta kentta) {
		super();
		this.pvm = pvm;
		this.kello = kello;
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
		this.maalintekija = maalintekija;
		this.kentta = kentta;
	}

	public String getPvm() {
		return pvm;
	}
	
	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public Long getId() {
		return id;
	}

	public String getKjoukkue() {
		return kjoukkue;
	}

	public String getVjoukkue() {
		return vjoukkue;
	}

	public String getTulos() {
		return tulos;
	}

	public String getMaalintekija() {
		return maalintekija;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setKjoukkue(String kjoukkue) {
		this.kjoukkue = kjoukkue;
	}

	public void setVjoukkue(String vjoukkue) {
		this.vjoukkue = vjoukkue;
	}

	public void setTulos(String tulos) {
		this.tulos = tulos;
	}

	public void setMaalintekija(String maalintekija) {
		this.maalintekija = maalintekija;
	}

	public String getKello() {
		return kello;
	}

	public void setKello(String kello) {
		this.kello = kello;
	}

	public void setKentta(Kentta kentta) {
		this.kentta = kentta;
	}

	public Kentta getKentta() {
		return kentta;
	}

	@Override
	public String toString() {
		return "Ottelu [Id=" + id + ", kjoukkue=" + kjoukkue + ", vjoukkue=" + vjoukkue + ", tulos=" + tulos
				+ ", kentta=" + kentta + ", maalintekija=" + maalintekija + "]";
	}

}
