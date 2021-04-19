package com.banque.entity;

import java.util.Collection;
import java.util.Date;



public class CompteCourant extends Compte{
    private float decouvert;

    public CompteCourant() {
        super();
    }

    public CompteCourant(Integer num_compte, String code_type_compte, float solde_compte, Integer code_titulaire, Titulaire titulaire, float decouvert) {
        super(num_compte, code_type_compte, solde_compte, code_titulaire, titulaire);
        this.decouvert = decouvert;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(float decouvert) {
        this.decouvert = decouvert;
    }

}
