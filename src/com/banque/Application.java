package com.banque;

import java.util.ArrayList;

import com.banque.dao.TitulaireDao;
import com.banque.dao.impl.TitulaireDaoImpl;
import com.banque.entity.Titulaire;

public class Application {

	public static void main(String[] args) {
		
		TitulaireDao titulaireDao = new TitulaireDaoImpl();
		ArrayList<Titulaire> titulaires = titulaireDao.readAll();
		
		System.out.println("__________APPLI readAll____________");
		for(Titulaire titulaire : titulaires) {			
			System.out.println(titulaire);
		}
		System.out.println("\n");
		System.out.println("____________APPLI getByCode__________");
		Titulaire titulaire = titulaireDao.getByCode(4451);
		System.out.println(titulaire);
		
	
	} 

}
