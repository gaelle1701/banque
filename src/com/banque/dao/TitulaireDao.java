package com.banque.dao;

import java.util.ArrayList;

import com.banque.entity.Titulaire;

public interface TitulaireDao {

	public int create(Titulaire titulaire);
	public ArrayList<Titulaire> readAll();
	public Titulaire getByCode(int code_titulaire);
	public int update(Titulaire titulaire);
	public int delete(Titulaire titulaire);

}
