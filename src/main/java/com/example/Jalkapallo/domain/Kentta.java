package com.example.Jalkapallo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "kentta")
public class Kentta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kenttaid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kentta")
	@JsonIgnoreProperties("kentta")
	private List<Ottelu> ottelut;
	
	public Kentta() {
		
	}

	public Kentta (String name) {
		super();
		this.name = name;
	}
	
	public Kentta (Long kenttaid, String name) {
	this.kenttaid = kenttaid;
	this.name = name;
	}

	public Long getKenttaid() {
		return kenttaid;
	}

	public String getName() {
		return name;
	}

	public void setKenttaid(Long kenttaid) {
		this.kenttaid = kenttaid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ottelu> getOttelut() {
		return ottelut;
	}
	
	public void setOttelut(List<Ottelu> ottelut) {
		this.ottelut = ottelut;
	}

	@Override
	public String toString() {
		return "Kentta [kenttaid=" + kenttaid + ", name=" + name + "]";
	}
	
	

	}
