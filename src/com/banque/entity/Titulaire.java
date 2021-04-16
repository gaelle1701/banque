package com.banque.entity;

public class Titulaire {
	
	private Integer code;  // car objet null à la créa
	private String prenom;
	private String nom;
	private String adresse;
	private String code_postal;
	
//	getter / setter 
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	
	@Override
	public String toString() {
		return "Titulaire : code " + code + ",  " + prenom + ",  " + nom + ",  " + adresse
				+ ",  " + code_postal;
	}
	
	
	
	

}
