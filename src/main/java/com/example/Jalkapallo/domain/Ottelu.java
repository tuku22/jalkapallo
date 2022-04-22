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
	private int id;
	private String kello;
	private String kjoukkue;
	private String vjoukkue;
	private int tulos;
	private String maalintekija;
	
	@ManyToOne
	@JoinColumn(name = "kenttaid")
	@JsonIgnoreProperties("ottelut")
	private Kentta kentta;

	

	public Ottelu() {
		super();
	}

	public Ottelu(int id, String kello, String kjoukkue, String vjoukkue, int tulos, String maalintekija, Kentta kentta) {
		super();
		this.id = id;
		this.kello = kello;
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
		this.maalintekija = maalintekija;
		this.kentta = kentta;
	}
	
	public Ottelu(String kello, String kjoukkue, String vjoukkue, int tulos, String maalintekija, Kentta kentta) {
		super();
		this.kello = kello;
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
		this.maalintekija = maalintekija;
		this.kentta = kentta;
	}

	public int getId() {
		return id;
	}

	public String getKjoukkue() {
		return kjoukkue;
	}

	public String getVjoukkue() {
		return vjoukkue;
	}

	public int getTulos() {
		return tulos;
	}


	public String getMaalintekija() {
		return maalintekija;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKjoukkue(String kjoukkue) {
		this.kjoukkue = kjoukkue;
	}

	public void setVjoukkue(String vjoukkue) {
		this.vjoukkue = vjoukkue;
	}

	public void setTulos(int tulos) {
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


	@Override
	public String toString() {
		return "Ottelu [Id=" + id + ", kjoukkue=" + kjoukkue + ", vjoukkue=" + vjoukkue + ", tulos=" + tulos
				+ ", kentta=" + kentta + ", maalintekija=" + maalintekija + "]";
	}

	

	
}


