package com.banque.entity;

public  class Compte {
    private Integer num_compte;
    private String code_type_compte;
    private float solde_compte;
    private Integer code_titulaire;
    private Titulaire titulaire ;
    private TypeCompte typeCompte;

    public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Titulaire getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Titulaire titulaire) {
        this.titulaire = titulaire;
    }

    
    
    
    public Compte() {}

    public Compte(Integer num_compte, String code_type_compte, float solde_compte, Integer code_titulaire, Titulaire titulaire) {
        this.num_compte = num_compte;
        this.titulaire = titulaire;
        this.code_type_compte = code_type_compte;
        this.solde_compte = solde_compte;
        this.code_titulaire = code_titulaire;
    }

    public Integer getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(Integer num_compte) {
        this.num_compte = num_compte;
    }

    public String getCode_type_compte() {
        return code_type_compte;
    }

    public void setCode_type_compte(String code_type_compte) {
        this.code_type_compte = code_type_compte;
    }

    public float getSolde_compte() {
        return solde_compte;
    }

    public void setSolde_compte(float solde_compte) {
        this.solde_compte = solde_compte;
    }

    public Integer getCode_titulaire() {
        return code_titulaire;
    }

    public void setCode_titulaire(Integer code_titulaire) {
        this.code_titulaire = code_titulaire;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "num_compte=" + num_compte +
                ", code_type_compte='" + code_type_compte + '\'' +
                ", solde_compte=" + solde_compte +
                ", code_titulaire=" + code_titulaire +
                '}';
    }
}
