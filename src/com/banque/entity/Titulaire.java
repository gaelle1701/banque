package com.banque.entity;

public class Titulaire {
	private Integer code_titulaire;  // car objet null à la créa
	private String prenom;
	private String nom;
	private String adresse;
	private String code_postal;
	private Compte compte;

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	//	getter / setter
	public Integer getCode_titulaire() {
		return code_titulaire;
	}

	public void setCode_titulaire(Integer code_titulaire) {
		this.code_titulaire = code_titulaire;
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
		return "Titulaire : code " + code_titulaire + ",  " + prenom + ",  " + nom + ",  " + adresse
				+ ",  " + code_postal;
	}
	
	
	
	

}
