package com.example.Jalkapallo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kentta {
	



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kenttaid;
	private String kentta;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kentta")
	private List<Ottelu> ottelut;

	public Kentta(Long kenttaid, String kentta) {
	super();
	this.kenttaid = kenttaid;
	this.kentta = kentta;
	}
	
	public Kentta(String kentta) {
		super();
		this.kentta = kentta;
	}

	public Kentta() {
	super();
	}

	public Long getKenttaid() {
	return kenttaid;
	}

	public String getKentta() {
	return kentta;
	}

	public List<Ottelu> getOttelut() {
	return ottelut;
	}

	public void setKenttaid(Long kenttaid) {
	this.kenttaid = kenttaid;
	}

	public void setKentta(String kentta) {
	this.kentta = kentta;
	}

	public void setOttelut(List<Ottelu> ottelut) {
	this.ottelut = ottelut;
	}

	@Override
	public String toString() {
	return "Kentta [kenttaid=" + kenttaid + ", kentta=" + kentta + "]";
	}


	}
