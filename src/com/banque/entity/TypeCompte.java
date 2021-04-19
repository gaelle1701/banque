package com.banque.entity;

public class TypeCompte {
	private String code_type_compte;
	private String intitule;


	public String getCode_type_compte() {
		return code_type_compte;
	}



	public void setCode_type_compte(String code_type_compte) {
		this.code_type_compte = code_type_compte;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	@Override
	public String toString() {
		return "TypeCompte : code_type : " + code_type_compte + ", intitulé : " + intitule ;
	}
	
	

}
