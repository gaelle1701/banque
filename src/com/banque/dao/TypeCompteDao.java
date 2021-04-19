package com.banque.dao;

import java.util.ArrayList;


import com.banque.entity.TypeCompte;

public interface TypeCompteDao {
	public TypeCompte getByType(String code_type);
	public int create(TypeCompte typeCompte);
	public ArrayList<TypeCompte> readAll();
	public int update(TypeCompte typeCompte);
	public int delete(TypeCompte typeCompte);

}
