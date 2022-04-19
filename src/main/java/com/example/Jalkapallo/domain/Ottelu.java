 package com.example.Jalkapallo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Ottelu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	private String kjoukkue;
	private String vjoukkue;
	private int tulos;

	private String maalintekija;
	
	@OneToMany
	@JoinColumn(name = "kenttaid")
	private Kentta kentta;
	
	public Ottelu(String kjoukkue, String vjoukkue, int tulos, Kentta kentta2, String maalintekija) {
		super();
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
	
		this.maalintekija = maalintekija;
	}

	public Ottelu() {
		super();
	}

	public Ottelu(int id, String kjoukkue, String vjoukkue, int tulos, String kentta, String maalintekija) {
		super();
		Id = id;
		this.kjoukkue = kjoukkue;
		this.vjoukkue = vjoukkue;
		this.tulos = tulos;
		
		this.maalintekija = maalintekija;
	}

	public int getId() {
		return Id;
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
		Id = id;
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

	@Override
	public String toString() {
		return "Ottelu [Id=" + Id + ", kjoukkue=" + kjoukkue + ", vjoukkue=" + vjoukkue + ", tulos=" + tulos
				+ ", kentta=" + kentta + ", maalintekija=" + maalintekija + "]";
	}
	
	
	
}


