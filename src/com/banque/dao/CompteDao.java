package com.banque.dao;

import com.banque.entity.Compte;
import com.banque.entity.TypeCompte;

import java.util.ArrayList;

public interface CompteDao {
    //methodes en contrat du CompteDAO
    public int create(Compte compte);
    public ArrayList<Compte> readAll();
    public Compte getByNum(int num_compte);
    public int update(Compte compte);
    public int delete(Compte compte);
    //public Compte getByTitulaire(int code_titulaire);
//	public Compte getByType(String code_type_compte);
	public Compte getByType(String code_type_compte, int code_titulaire);
	public ArrayList<Compte> getByTitulaire(int code_titulaire);
    

  
}
